package de.upb.soot.jimple.interpreter.systemTest.operators;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import java.util.Collections;
import java.util.List;

/**
 * @author Manuel Benz created on 11.07.18
 */
public abstract class AbstractOpsTest extends AbstractInterpreterSystemTest {
  @Override
  protected List<String> getIncludes() {
    // we can exclude everything but this class since we do not have dependencies in this package
    return Collections.singletonList(getTargetClass());
  }
}
