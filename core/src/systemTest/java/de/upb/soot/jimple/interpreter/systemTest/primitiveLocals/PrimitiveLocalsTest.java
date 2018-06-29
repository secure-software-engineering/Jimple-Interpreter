package de.upb.soot.jimple.interpreter.systemTest.primitiveLocals;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.Test;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class PrimitiveLocalsTest extends AbstractInterpreterSystemTest {

  @Test
  public void primitive_int() {
    final Object res = interpret("void primitive_int()");
    assertEmtpyResult(res);
    assertPrintsOutput("512");
  }

  @Test
  public void primitive_byte() {
  }

  @Test
  public void primitive_char() {
  }

  @Test
  public void primitive_short() {
  }

  @Test
  public void primitive_float() {
  }

  @Test
  public void primitive_long() {
  }

  @Test
  public void primitive_double() {
  }
}