package de.upb.soot.jimple.interpreter.systemTest.operators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz
 * created on 12.07.18
 */
class BooleanOpsTest extends AbstractOpsTest {

  @Test void logicalOr(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test void logicalAnd(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test void logicalNot(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}