package de.upb.soot.jimple.interpreter.systemTest.emulation;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel Benz created on 04.07.18
 */
public class ObjectsTest extends AbstractInterpreterSystemTest {

  @Test
  public void callWithJObject() {
    final Object res = interpret("void callWithJObject()");
    assertEmtpyResult(res);
    final String output = out.toString();
    Assert.assertFalse(
        "JObject was not converted to Java Object. The print stream just print the JObject.toString() result: " + out,
        output.contains("de.upb.soot.jimple.interpreter.values.JObject"));
    assertPrintsOutput("Foo");
  }
}