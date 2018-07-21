package de.upb.soot.jimple.interpreter.systemTest.staticInvoke;

public class StaticInvoke {

  public static void staticInvoke() {
    callee();
  }

  private static void callee() {
    System.out.println("foo");
  }
}