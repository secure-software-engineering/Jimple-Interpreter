package de.upb.soot.jimple.interpreter.systemTest;

import de.upb.soot.jimple.interpreter.Configuration;
import de.upb.soot.jimple.interpreter.EntryPoint;
import de.upb.soot.jimple.interpreter.JimpleInterpreter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

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
   * @param methodSubSig The sub-signature of this method e.g., 'void foo(int,float)', 'int bar()'
   * @return
   */
  protected Object interpret(String methodSubSig) {
    return interpreter.interpret(new EntryPoint(String.format("<%s: %s>", getTargetClass(), methodSubSig)));
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
}
