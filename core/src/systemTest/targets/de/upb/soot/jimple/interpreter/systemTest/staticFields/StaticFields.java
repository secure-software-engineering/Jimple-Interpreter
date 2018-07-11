package de.upb.soot.jimple.interpreter.systemTest.staticFields;

public class StaticFields {
  public static void staticFields() {
    A.methodA();
    System.out.println(A.a + A.b);
  }
}
