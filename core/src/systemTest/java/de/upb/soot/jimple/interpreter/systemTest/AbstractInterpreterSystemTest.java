package de.upb.soot.jimple.interpreter.systemTest;

import de.upb.soot.jimple.interpreter.Configuration;
import de.upb.soot.jimple.interpreter.EntryPoint;
import de.upb.soot.jimple.interpreter.JimpleInterpreter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

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
@RunWith(PowerMockRunner.class)
public abstract class AbstractInterpreterSystemTest {

  protected final static JimpleInterpreter interpreter;

  private static ByteArrayOutputStream out;

  static {
    final Configuration configuration = new Configuration("target/systemTest-target-classes");
    out = new ByteArrayOutputStream();
    configuration.setOutputStream(new PrintStream(out));
    configuration.setDumpJimple(true);
    interpreter = new JimpleInterpreter(configuration);
  }

  protected static void assertPrintsOutput(String expected) {
    final String output = out.toString();
    Assert.assertTrue(String.format("Output does not contain expected string.\nExpected: %s\nOutput: %s", expected, output),
        output.contains("expect"));
  }

  protected static void assertEmtpyResult(Object result) {
    Assert.assertNotNull("Expected empty result but was null", result);
    final String resString = result.toString();
    Assert.assertEquals("Expected empty result but was" + resString, "", resString);
  }

  @Before
  public void setUp() throws Exception {
    out.reset();
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

}
