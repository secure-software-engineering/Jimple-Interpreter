package de.upb.soot.jimple.interpreter.systemTest.constants;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.jupiter.api.Test;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class ConstantsTest extends AbstractInterpreterSystemTest {

  @Test
  public void intConstant() {
    standardSoutTest("void intConstant()", "512");
  }

  @Test
  public void byteConstant() {
    standardSoutTest("void byteConstant()", "0");
  }

  @Test
  public void charConstant() {
    standardSoutTest("void charConstant()", "a");
  }

  @Test
  public void shortConstant() {
    standardSoutTest("void shortConstant()", "10");
  }

  @Test
  public void floatConstant() {
    standardSoutTest("void floatConstant()", "3.14");
  }

  @Test
  public void longConstant() {
    standardSoutTest("void longConstant()", "123456789");
  }

  @Test
  public void doubleConstant() {
    standardSoutTest("void doubleConstant()", "1.96969654");
  }

  @Test
  public void stringConstant() {
    standardSoutTest("void stringConstant()", "foo");
  }

  @Test
  public void classConstant() {
    standardSoutTest("void classConstant()", "de.upb.soot.jimple.interpreter.systemTest.constants.Constants");
  }
}