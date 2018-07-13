package de.upb.soot.jimple.interpreter.systemTest.fieldReference;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class FieldReferenceTest extends AbstractInterpreterSystemTest {

  @Test
  void ownField(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void ownFieldWrite(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void otherField(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void otherFieldWrite(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void otherFieldWrite2(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void ownFieldObject(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void ownFieldWriteObject(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void otherFieldObject(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void otherFieldWriteObject(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void otherFieldWrite2Object(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void finalField(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}