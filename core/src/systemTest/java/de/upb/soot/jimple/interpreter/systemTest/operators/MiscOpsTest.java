package de.upb.soot.jimple.interpreter.systemTest.operators;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.Test;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class MiscOpsTest extends AbstractInterpreterSystemTest {

  @Test
  public void instanceofOperator() {
    standardSoutTest("instanceofOperator", "true");
  }

  @Test
  public void ternaryOperator() {
    standardSoutTest("ternaryOperator", "foo");
  }
}