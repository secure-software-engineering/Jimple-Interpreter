package de.upb.soot.jimple.interpreter.systemTest.specialInvoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SpecialInvoke {

  public static void specialInvoke() {
	  mySpecialInvoke();
  }

  private static void mySpecialInvoke() {
	  callee();	
  }

  private static void callee() {
    System.out.println("foo");
  }

  public static void staticInvokeReflection() throws NoSuchMethodException {
    // Invoking static method using reflection
    Method method = SpecialInvoke.class.getMethod("mySpecialInvoke");
    try {
      method.invoke(null);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}