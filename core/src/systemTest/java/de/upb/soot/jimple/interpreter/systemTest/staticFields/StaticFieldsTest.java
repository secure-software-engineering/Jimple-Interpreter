package de.upb.soot.jimple.interpreter.systemTest.staticFields;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class StaticFieldsTest extends AbstractInterpreterSystemTest {

  @Test
  public void finalField(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  public void nonFinalField(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  public void nonFinalFieldAltered(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  public void doesNotResetDuringTestMethod() {
    standardSoutTest("void nonFinalField()", "5");
    standardSoutTest("void nonFinalFieldAltered()", "6");
    standardSoutTest("void nonFinalField()", "6");
  }
}