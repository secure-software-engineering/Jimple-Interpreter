package de.upb.soot.jimple.interpreter.systemTest.specialInvoke;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Eric Bodden created on 19.07.18
 */
class SpecialInvokeTest extends AbstractInterpreterSystemTest {

  @Test
  void specialInvoke(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void specialInvokeReflection(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}