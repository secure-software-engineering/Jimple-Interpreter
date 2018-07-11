package de.upb.soot.jimple.interpreter.systemTest.operators;

import org.junit.jupiter.api.Test;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class MiscOpsTest extends AbstractOpsTest {

  @Test
  public void instanceofOperator() {
    standardSoutTest("instanceofOperator", "true");
  }

  @Test
  public void ternaryOperator() {
    standardSoutTest("ternaryOperator", "foo");
  }

}