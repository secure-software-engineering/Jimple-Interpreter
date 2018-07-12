package de.upb.soot.jimple.interpreter.systemTest.staticInvoke;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class StaticInvokeTest extends AbstractInterpreterSystemTest {

  @Test
  void staticInvoke(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void staticInvokeReflection(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}