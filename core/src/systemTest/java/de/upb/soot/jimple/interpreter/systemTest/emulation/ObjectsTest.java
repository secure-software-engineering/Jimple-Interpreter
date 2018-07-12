package de.upb.soot.jimple.interpreter.systemTest.emulation;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class ObjectsTest extends AbstractInterpreterSystemTest {

  @Test
  void jObjectToJavaObject(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void systemOut(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}