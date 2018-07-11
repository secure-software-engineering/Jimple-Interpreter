package de.upb.soot.jimple.interpreter.systemTest.operators;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.Test;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class BooleanOpsTest extends AbstractInterpreterSystemTest {

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