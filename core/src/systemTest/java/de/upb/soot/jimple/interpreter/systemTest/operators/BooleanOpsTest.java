package de.upb.soot.jimple.interpreter.systemTest.operators;

import org.junit.jupiter.api.Test;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class BooleanOpsTest extends AbstractOpsTest {

  @Test
  public void logicalOr() {
    standardSoutTest("logicalOr", "true");
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