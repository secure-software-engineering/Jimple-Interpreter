package de.upb.soot.jimple.interpreter.systemTest.arrays;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class ArraysTest extends AbstractInterpreterSystemTest {

  @Test
  void primitiveArray(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void objectArray(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void manualAssignment(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void twoDimensions(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}