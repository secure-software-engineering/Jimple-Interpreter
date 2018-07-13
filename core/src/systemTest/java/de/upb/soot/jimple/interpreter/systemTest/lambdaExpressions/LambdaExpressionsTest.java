package de.upb.soot.jimple.interpreter.systemTest.lambdaExpressions;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class LambdaExpressionsTest extends AbstractInterpreterSystemTest {

  @Test
  void lambdaRet(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void lambdaParam(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void lambdaVoid(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void passToMethod(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void functionPointer(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void functionPointerStatic(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}