package de.upb.soot.jimple.interpreter.systemTest.nestedControlStatements;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class NestedControlStatementsTest extends AbstractInterpreterSystemTest {

  @Test
  void nestedIfElse(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedSwitchIf(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedWhileIf(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedForIf(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedSwitchSwitch(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedIfSwitch(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedWhileSwitch(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedForSwitch(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedWhileWhile(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedIfWhile(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedSwitchWhile(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedForWhile(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedIfFor(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nested_switch_in_for(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedWhileFor(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedSwitchFor(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void nestedForFor(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}