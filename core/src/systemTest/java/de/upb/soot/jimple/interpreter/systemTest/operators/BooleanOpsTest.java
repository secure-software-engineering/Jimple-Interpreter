package de.upb.soot.jimple.interpreter.systemTest.operators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class BooleanOpsTest extends AbstractOpsTest {

  @Test
  public void logicalOr(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  public void logicalAnd() {
    standardSoutTest("logicalAnd", "true");
  }

  @Test
  public void logicalNot() {
    standardSoutTest("logicalNot", "true");
  }

}