package de.upb.soot.jimple.interpreter.systemTest.staticFields;

import de.upb.soot.jimple.interpreter.systemTest.AbstractInterpreterSystemTest;

import org.junit.Test;

/**
 * @author Manuel Benz created on 11.07.18
 */
public class StaticFieldsTest extends AbstractInterpreterSystemTest {

  @Test
  public void finalField() {
    standardSoutTest("finalField", "10");
  }

  @Test
  public void nonFinalField() {
    standardSoutTest("nonFinalField", "5");
  }

  @Test
  public void nonFinalFieldAltered() {
    standardSoutTest("nonFinalFieldAltered", "6");
  }

  @Test
  public void doesNotResetDuringTestMethod() {
    standardSoutTest("nonFinalField", "5");
    standardSoutTest("nonFinalFieldAltered", "6");
    standardSoutTest("nonFinalField", "6");
  }
}