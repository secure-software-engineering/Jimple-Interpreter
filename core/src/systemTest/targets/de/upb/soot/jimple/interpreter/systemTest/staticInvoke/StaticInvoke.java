package de.upb.soot.jimple.interpreter.systemTest.staticInvoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StaticInvoke {

  public static void staticInvoke() {
    callee();
  }

  private static void callee() {
    System.out.println("foo");
  }

    public static void main(String[] args) {
        try {
            staticInvokeReflection();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

  public static void staticInvokeReflection() throws NoSuchMethodException {
    // Invoking static method using reflection
    Method method = StaticInvoke.class.getMethod("staticInvoke");
    try {
      method.invoke(null);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}