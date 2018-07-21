package de.upb.soot.jimple.interpreter.systemTest.reflection;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 21.07.18
 */
class ReflectionTest extends AbstractInterpreterSystemTest {

  @Test
  void staticInvokeReflection(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}