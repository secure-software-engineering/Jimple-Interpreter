package de.upb.soot.jimple.interpreter.systemTest.operators;

import org.junit.jupiter.api.Test;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class DoubleOpsTest extends AbstractOpsTest {

  @Test
  public void addition() {
    standardSoutTest("addition", "1.6777222E7");
  }

  @Test
  public void subtraction() {
    standardSoutTest("subtraction", "-1.6777212E7");
  }

  @Test
  public void multiplication() {
    standardSoutTest("multiplication", "8.3886085E7");
  }

  @Test
  public void division() {
    standardSoutTest("division", "2.980232061133858E-7");
  }

  @Test
  public void modulus() {
    standardSoutTest("modulus", "5.0");
  }

  @Test
  public void simpleAssignmentOperator() {
    standardSoutTest("simpleAssignmentOperator", "1.6777217E7");
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