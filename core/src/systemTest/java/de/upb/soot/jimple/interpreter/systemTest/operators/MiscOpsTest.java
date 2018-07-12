package de.upb.soot.jimple.interpreter.systemTest.operators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class MiscOpsTest extends AbstractOpsTest {

  @Test
  void instanceofOperator(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void ternaryOperator(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}