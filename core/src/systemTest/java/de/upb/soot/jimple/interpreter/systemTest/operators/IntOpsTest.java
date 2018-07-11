package de.upb.soot.jimple.interpreter.systemTest.operators;

import org.junit.jupiter.api.Test;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class IntOpsTest extends AbstractOpsTest {

  @Test
  public void addition() {
    standardSoutTest("addition", "10");
  }

  @Test
  public void subtraction() {
    standardSoutTest("subtraction", "0");
  }

  @Test
  public void multiplication() {
    standardSoutTest("multiplication", "25");
  }

  @Test
  public void division() {
    standardSoutTest("division", "1");
  }

  @Test
  public void modulus() {
    standardSoutTest("modulus", "0");
  }

  @Test
  public void simpleAssignmentOperator() {
    standardSoutTest("simpleAssignmentOperator", "5");
  }

  @Test
  public void bitwiseAnd() {
    standardSoutTest("bitwiseAnd", "5");
  }

  @Test
  public void bitwiseOr() {
    standardSoutTest("bitwiseOr", "5");
  }

  @Test
  public void bitwiseXor() {
    standardSoutTest("bitwiseXor", "0");
  }

  @Test
  public void bitwiseCompliment() {
    standardSoutTest("bitwiseCompliment", "-6");
  }

  @Test
  public void bitwiseLeftShift() {
    standardSoutTest("bitwiseLeftShift", "20");
  }

  @Test
  public void bitwiseRightShift() {
    standardSoutTest("bitwiseRightShift", "1");
  }

  @Test
  public void bitwiseRightShiftZerofill() {
    standardSoutTest("bitwiseRightShiftZerofill", "1");
  }

  @Test
  public void equals() {
    standardSoutTest("equals", "true");
  }

  @Test
  public void notEquals() {
    standardSoutTest("notEquals", "false");
  }

  @Test
  public void greateThan() {
    standardSoutTest("greateThan", "false");
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
    standardSoutTest("lessOrEqualsThan", "true");
  }

}