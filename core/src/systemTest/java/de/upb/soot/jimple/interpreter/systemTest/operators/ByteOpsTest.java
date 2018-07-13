package de.upb.soot.jimple.interpreter.systemTest.operators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class ByteOpsTest extends AbstractOpsTest {

  @Test
  void addition(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void subtraction(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void multiplication(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void division(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void modulus(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void simpleAssignmentOperator(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void bitwiseAnd(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void bitwiseOr(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void bitwiseXor(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void bitwiseCompliment(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void bitwiseLeftShift(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void bitwiseRightShift(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void bitwiseRightShiftZerofill(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void equals(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void notEquals(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void greateThan(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void lessThan(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void greaterOrEqualsThan(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void lessOrEqualsThan(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}