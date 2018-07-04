package de.upb.soot.jimple.interpreter.systemTest.emulation;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.Test;

/**
 * @author Manuel Benz created on 04.07.18
 */
public class ObjectsTest extends AbstractInterpreterSystemTest {

  @Test
  public void callWithJObject() {
    final Object res = interpret("void callWithJObject()");
    assertEmtpyResult(res);
    assertPrintsOutput("Foo");
  }
}