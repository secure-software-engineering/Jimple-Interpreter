package de.upb.soot.jimple.interpreter.systemTest;

import de.upb.soot.jimple.interpreter.Configuration;
import de.upb.soot.jimple.interpreter.EntryPoint;
import de.upb.soot.jimple.interpreter.JimpleInterpreter;

import com.google.common.collect.Lists;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.Local;
import soot.Modifier;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.VoidType;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NullConstant;

/**
 * @author Manuel Benz created on 29.06.18
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractInterpreterSystemTest {

  private static final String TARGET_SYSTEM_TEST_TARGET_CLASSES = "target/systemTest-target-classes";
  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractInterpreterSystemTest.class);

  protected ByteArrayOutputStream out;
  protected JimpleInterpreter interpreter;

  @BeforeAll
  public void setupInterpreter() {
    // start the interpreter once so that a soot instance is build with the default config
    System.out.println("Building Soot's Scene before test class");
    Configuration configuration = new Configuration(TARGET_SYSTEM_TEST_TARGET_CLASSES);
    out = new ByteArrayOutputStream();
    configuration.setOutputStream(new PrintStream(out));
    configuration.setDumpJimple(true);
    configuration.setClearJimpleOutDir(false);
    configuration.setAdditionalSootOptions(o -> {
      // exclude all test classes
      o.set_include_all(false);
      o.set_exclude(Lists.newArrayList("de.*", "java.*", "sun.*", "javax.*"));
      o.set_no_bodies_for_excluded(true);
      o.set_include(getIncludes());
      o.set_output_dir("./jimpleOut/" + getClass().getPackage().getName());
    });
    interpreter = new JimpleInterpreter(configuration);
    System.out.println("Finished building Scene");
  }

  @BeforeEach
  public void setUpTestCase() {
    out.reset();
    interpreter.reset();
  }

  /**
   *
   * @param methodSubSig
   *          The sub-signature of this method e.g., 'void foo(int,float)', 'int bar()'
   * @return
   */
  protected Object interpret(String methodSubSig) {
    final SootMethod dummyMain = createTestTarget(getTargetClass(), methodSubSig);
    return interpreter.interpret(new EntryPoint(dummyMain.getSignature()));
  }

  /**
   * By default returns the package of the current class. So only classes below this package are analyzed by Soot and
   * available. Overwrite to include the JDK for example ("java.*").
   * 
   * @return
   */
  protected List<String> getIncludes() {
    return Collections.singletonList(getClass().getPackage().getName() + ".*");
  }

  /**
   * By default retrieves the name of a target class by taking the test's class name and removing "Test" at the end of the
   * identifier. This assumes that tests are located in the same package as the targets to test and that they are named
   * "<TargetClassName>Test". If this assumption does not hold for a specific test, overwrite accordingly.
   *
   * @return
   */
  protected String getTargetClass() {
    final Class<? extends AbstractInterpreterSystemTest> testClass = getClass();
    final String testClassName = testClass.getName();
    return testClassName.substring(0, testClassName.lastIndexOf("Test"));
  }

  private SootMethod createTestTarget(String targetClassSig, String targetMethodSubsig) {
    final SootClass targetClass = Scene.v().forceResolve(targetClassSig, SootClass.BODIES);
    SootMethod targetMethod = targetClass.getMethod(targetMethodSubsig);
    if (targetMethod == null) {
      throw new RuntimeException("The method with name " + targetMethodSubsig + " in class " + targetClassSig
          + " was not found in the Soot Scene.");
    }

    // we do not need a calling context for static methods
    if (targetMethod.isStatic()) {
      return targetMethod;
    }

    SootClass dummyClass = makeDummyClass(targetMethod);
    Scene.v().addBasicClass(dummyClass.toString(), SootClass.BODIES);
    SootClass c = Scene.v().forceResolve(dummyClass.toString(), SootClass.BODIES);
    c.setApplicationClass();
    Scene.v().setEntryPoints(Collections.singletonList(c.getMethodByName("main")));
    return dummyClass.getMethodByName("main");
  }

  private SootClass makeDummyClass(SootMethod sootTestMethod) {
    SootClass sootClass = new SootClass("dummyClass");
    SootMethod mainMethod
        = new SootMethod("main", Arrays.asList(new Type[] { ArrayType.v(RefType.v("java.lang.String"), 1) }), VoidType.v(),
            Modifier.PUBLIC | Modifier.STATIC);
    sootClass.addMethod(mainMethod);

    JimpleBody body = Jimple.v().newBody(mainMethod);
    mainMethod.setActiveBody(body);
    RefType testCaseType = RefType.v(sootTestMethod.getDeclaringClass());
    Local allocatedTestObj = Jimple.v().newLocal("dummyObj", testCaseType);
    body.getLocals().add(allocatedTestObj);
    body.getUnits().add(Jimple.v().newAssignStmt(allocatedTestObj, Jimple.v().newNewExpr(testCaseType)));
    ArrayList args = new ArrayList(sootTestMethod.getParameterCount());
    for (int i = 0; i < sootTestMethod.getParameterCount(); i++) {
      args.add(NullConstant.v());
    }
    body.getUnits()
        .add(Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr(allocatedTestObj, sootTestMethod.makeRef(), args)));

    Scene.v().addClass(sootClass);
    return sootClass;
  }

  /**
   * Basic test case skeleton that expects a System.out.print* as last executed statement.
   * <p/>
   * Note: Since System.out.print* is a void function, the interpreter returns the empty result.
   *
   * @param targetMethodSubSignature
   *          Sub-signature of the tested method, e.g. 'void foo()'
   * @param expectedOutput
   *          String that has to be contained in the printed output to pass the test
   */
  protected void standardSoutTest(String targetMethodSubSignature, String expectedOutput) {
    if (!targetMethodSubSignature.contains(" ")) {
      // we just got a name but not a signature due to not having a return type
      LOGGER.warn("Test method name without signature given, implying void method with no arguments.");
      targetMethodSubSignature = "void " + targetMethodSubSignature + "()";
    }

    final Object res = interpret(targetMethodSubSignature);
    assertEmtpyResult(res);
    assertPrintsOutput(expectedOutput);
  }

  protected String getOutput() {
    return out.toString();
  }

  protected void assertPrintsOutput(String expected) {
    final String output = getOutput();
    Assertions.assertTrue(output.contains(expected), "Output does not contain expected string.");
  }

  protected void assertEmtpyResult(Object result) {
    Assertions.assertNotNull(result, "Expected empty result but was null");
    final String resString = result.toString();
    Assertions.assertEquals("", resString, "Expected empty result but was" + resString);
  }

  /**
   * Compares the output and return value of the executed target-method with the interpreted target-method.
   * <p/>
   * Determines the target-method (method to test) by using same name as the test-method in a class retrieved from
   * {@link AbstractInterpreterSystemTest#getTargetClass()}.
   * <p/>
   * Make sure to name your test methods equal to the target method that should be interpreted and your test-classes
   * #TargetClassName#Test!
   * 
   * @param args
   */
  protected void assertInterpretationEqualsExecution(TestInfo testInfo, Object... args) {
    if (args.length != 0) {
      LOGGER.warn("Arguments to interpreter currently not supported! Arguments will be ignored...");
    }

    final PrintStream oldOut = System.out;
    ByteArrayOutputStream newOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(newOut));

    try {
      final String targetClass = getTargetClass();
      final Class<?> targetClazz = Class.forName(targetClass);
      final Object targetInstance = targetClazz.newInstance();
      final String targetMethodName = testInfo.getTestMethod().get().getName();
      final Method targetMethod = targetClazz.getMethod(targetMethodName);
      final String executedResult = Objects.toString(targetMethod.invoke(targetInstance), "");
      final String executedOutput = newOut.toString();

      final String returnType = targetMethod.getReturnType().getName();
      final String interpretedResult = Objects.toString(interpret(returnType + " " + targetMethodName + "()"), "");
      final String interpretedOutput = getOutput();

      Assertions.assertEquals(executedResult, interpretedResult,
          "Return values of interpreted and executed target method differ");
      Assertions.assertEquals(executedOutput, interpretedOutput, "Output of interpreted and executed target method differ.");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    System.setOut(oldOut);
  }
}
