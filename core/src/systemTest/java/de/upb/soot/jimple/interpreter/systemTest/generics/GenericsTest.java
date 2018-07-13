package de.upb.soot.jimple.interpreter.systemTest.generics;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class GenericsTest extends AbstractInterpreterSystemTest {

  @Test
  void list(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void boxedList(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nonJDK(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}