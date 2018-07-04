package de.upb.soot.jimple.interpreter.systemTest.emulation;

/**
 * @author Manuel Benz created on 04.07.18
 */
public class Objects {

  public void callWithJObject() {
    System.out.println(new Foo());
  }

  public static class Foo {
    @Override
    public String toString() {
      return "Foo";
    }
  }
}
