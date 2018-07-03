package de.upb.soot.jimple.interpreter.systemTest.staticInitializers;

/**
 * @author Manuel Benz created on 02.07.18
 */
public class StaticInitializer {
  private static String a = "A";
  private static String b ;

  static {
    b = "B";
    System.out.println(b);
    System.out.println(a);
  }
}
