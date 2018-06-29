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
    final Object res = interpret("void primitive_byte()");
    assertEmtpyResult(res);
    assertPrintsOutput("0");
  }

  @Test
  public void primitive_char() {
    final Object res = interpret("void primitive_char()");
    assertEmtpyResult(res);
    assertPrintsOutput("a");
  }

  @Test
  public void primitive_short() {
    final Object res = interpret("void primitive_short()");
    assertEmtpyResult(res);
    assertPrintsOutput("10");
  }

  @Test
  public void primitive_float() {
    final Object res = interpret("void primitive_float()");
    assertEmtpyResult(res);
    assertPrintsOutput("3.14");
  }

  @Test
  public void primitive_long() {
    final Object res = interpret("void primitive_long()");
    assertEmtpyResult(res);
    assertPrintsOutput("123456789");
  }

  @Test
  public void primitive_double() {
    final Object res = interpret("void primitive_double()");
    assertEmtpyResult(res);
    assertPrintsOutput("1.96969654");
  }
}