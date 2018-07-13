package de.upb.soot.jimple.interpreter.systemTest.interfaces;

/**
 * @author Manuel Benz created on 12.07.18
 */
public class D extends C {
  @Override
  public void printI2() {
    System.out.println("overwrites i2");
  }
}
