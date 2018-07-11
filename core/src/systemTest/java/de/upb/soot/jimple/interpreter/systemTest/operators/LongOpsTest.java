package de.upb.soot.jimple.interpreter.systemTest.operators;

import org.junit.jupiter.api.Test;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class LongOpsTest extends AbstractOpsTest {

  @Test
  public void addition() {
    standardSoutTest("addition", "2147483653");
  }

  @Test
  public void subtraction() {
    standardSoutTest("subtraction", "-2147483643");
  }

  @Test
  public void multiplication() {
    standardSoutTest("multiplication", "10737418240");
  }

  @Test
  public void division() {
    standardSoutTest("division", "0");
  }

  @Test
  public void modulus() {
    standardSoutTest("modulus", "5");
  }

  @Test
  public void simpleAssignmentOperator() {
    standardSoutTest("simpleAssignmentOperator", "2147483648");
  }

  @Test
  public void bitwiseAnd() {
    standardSoutTest("bitwiseAnd", "0");
  }

  @Test
  public void bitwiseOr() {
    standardSoutTest("bitwiseOr", "2147483653");
  }

  @Test
  public void bitwiseXor() {
    standardSoutTest("bitwiseXor", "2147483653");
  }

  @Test
  public void bitwiseCompliment() {
    standardSoutTest("bitwiseCompliment", "-2147483649");
  }

  @Test
  public void bitwiseLeftShift() {
    standardSoutTest("bitwiseLeftShift", "8589934592");
  }

  @Test
  public void bitwiseRightShift() {
    standardSoutTest("bitwiseRightShift", "536870912");
  }

  @Test
  public void bitwiseRightShiftZerofill() {
    standardSoutTest("bitwiseRightShiftZerofill", "536870912");
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