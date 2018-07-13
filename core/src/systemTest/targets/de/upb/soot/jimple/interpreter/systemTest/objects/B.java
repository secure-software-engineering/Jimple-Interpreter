package de.upb.soot.jimple.interpreter.systemTest.objects;

/**
 * @author Manuel Benz created on 12.07.18
 */
public class B {
  public B() {
    System.out.println("constructor");
  }

  @Override
  public String toString() {
    return "B";
  }
}
