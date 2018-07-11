package de.upb.soot.jimple.interpreter.systemTest.operators;

import org.junit.jupiter.api.Test;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class FloatOpsTest extends AbstractOpsTest {

  @Test
  public void addition() {
    standardSoutTest("addition", "10.5");
  }

  @Test
  public void subtraction() {
    standardSoutTest("subtraction", "-0.5");
  }

  @Test
  public void multiplication() {
    standardSoutTest("multiplication", "27.5");
  }

  @Test
  public void division() {
    standardSoutTest("division", "0.90909094");
  }

  @Test
  public void modulus() {
    standardSoutTest("modulus", "5.0");
  }

  @Test
  public void simpleAssignmentOperator() {
    standardSoutTest("simpleAssignmentOperator", "5.5");
  }

  @Test
  public void equals() {
    standardSoutTest("equals", "false");
  }

  @Test
  public void notEquals() {
    standardSoutTest("notEquals", "true");
  }

  @Test
  public void greateThan() {
    standardSoutTest("greateThan", "true");
  }

  @Test
  public void lessThan() {
    standardSoutTest("lessThan", "false");
  }

  @Test
  public void greaterOrEqualsThan() {
    standardSoutTest("greaterOrEqualsThan", "true");
  }

  @Test
  public void lessOrEqualsThan() {
    standardSoutTest("lessOrEqualsThan", "false");
  }

}