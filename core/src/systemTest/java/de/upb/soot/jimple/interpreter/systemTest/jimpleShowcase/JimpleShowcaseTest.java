package de.upb.soot.jimple.interpreter.systemTest.jimpleShowcase;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 13.07.18
 */
class JimpleShowcaseTest extends AbstractInterpreterSystemTest {

  @Test
  void justCreateJimpleForThisClass(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }
}