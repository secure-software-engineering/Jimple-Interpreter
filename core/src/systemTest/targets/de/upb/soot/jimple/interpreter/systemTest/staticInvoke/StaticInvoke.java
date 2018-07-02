package de.upb.soot.jimple.interpreter.systemTest.staticInvoke;

/**
 * @author Manuel Benz created on 02.07.18
 */
public class StaticInvoke {

  public static void callee() {
    System.out.println("out");
  }

  public static void caller() {
    callee();
  }
}
