package de.upb.soot.jimple.interpreter.systemTest.controlStatements;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class ControlStatementsTest extends AbstractInterpreterSystemTest {

  @Test
  void simpleIfElseIfTakeThen(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void simpleIfElseIfTakeElseIf(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void simpleIfElseIfTakeElse(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void simpleIfElseTakeThen(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void simpleIfElseTakeElse(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void tableSwitch(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void tableSwitchDefault(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void tableSwitchNoDefault(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void lookupSwitch(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void lookupSwitchDefault(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void lookupSwitchNoDefault(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void simpleWhile(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void simpleDoWhile(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void simpleFor(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void forIterArr(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void forIterList(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}