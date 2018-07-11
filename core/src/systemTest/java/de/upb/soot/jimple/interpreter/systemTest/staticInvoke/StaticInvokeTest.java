package de.upb.soot.jimple.interpreter.systemTest.staticInvoke;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;
import org.junit.jupiter.api.Test;

/**
 * @author Manuel Benz
 * created on 11.07.18
 */
public class StaticInvokeTest extends AbstractInterpreterSystemTest {

  @Test public void staticInvoke() {
    standardSoutTest("void staticInvoke()", "foo");
  }

  @Test public void staticInvokeReflection() {
    standardSoutTest("void staticInvokeReflection()", "foo");
  }
}