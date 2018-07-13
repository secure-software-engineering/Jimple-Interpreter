package de.upb.soot.jimple.interpreter.systemTest.interfaces;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class InterfacesTest extends AbstractInterpreterSystemTest {

  @Test
  void singleInterface(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void singleInterfaceDynDispatch(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void multipleInterface(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void inheritanceAndInterface(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void overwriteInterfaceMethod(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void anonymousImpl(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}