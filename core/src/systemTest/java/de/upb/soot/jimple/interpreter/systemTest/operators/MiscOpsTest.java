package de.upb.soot.jimple.interpreter.systemTest.operators;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Manuel Benz created on 12.07.18
 */
class MiscOpsTest extends AbstractOpsTest {

  @Test
  void instanceofOperator(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void instanceofOperator2(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Test
  void ternaryOperator(TestInfo testInfo) {
    assertInterpretationEqualsExecution(testInfo);
  }

  @Override
  protected List<String> getIncludes() {
    final ArrayList<String> includes = new ArrayList<>(super.getIncludes());
    includes.add(getTargetClass().replace("MiscOps", "A"));
    return includes;
  }
}