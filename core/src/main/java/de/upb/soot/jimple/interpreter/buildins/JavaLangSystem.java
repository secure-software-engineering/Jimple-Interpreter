package de.upb.soot.jimple.interpreter.buildins;

import de.upb.soot.jimple.interpreter.values.JClassObject;
import de.upb.soot.jimple.interpreter.values.JObject;

import java.io.InputStream;
import java.io.PrintStream;

import soot.Scene;
import soot.SootField;
import soot.SootMethod;

/**
 * @author Manuel Benz created on 03.07.18
 */
public class JavaLangSystem extends JClassObject {
  private final JObject sysOut;
  private final JObject sysErr;
  private final JObject sysIn;

  public JavaLangSystem(PrintStream outputStream, PrintStream errorStream, InputStream inputStream) {
    super(Scene.v().getSootClass("java.lang.System"));

    // mock stream object to use the configured streams instead of interpreting
    sysOut = new JObject(Scene.v().getSootClass("java.io.PrintStream")) {
      @Override
      public SootMethod getMethod(SootMethod method) {
        return MethodDelegate.instanceInvokeDelegate(method, outputStream);
      }
    };

    sysErr = new JObject(Scene.v().getSootClass("java.io.PrintStream")) {
      @Override
      public SootMethod getMethod(SootMethod method) {
        return MethodDelegate.instanceInvokeDelegate(method, errorStream);
      }
    };

    sysIn = new JObject(Scene.v().getSootClass("java.io.InputStream")) {
      @Override
      public SootMethod getMethod(SootMethod method) {
        return MethodDelegate.instanceInvokeDelegate(method, inputStream);
      }
    };
  }

  @Override
  public Object getFieldValue(SootField field) {
    final Object fieldValue = super.getFieldValue(field);

    // return mocked output/error/input stream objects
    if (fieldValue == null) {
      final String fieldName = field.getName();
      if (fieldName.equals("out")) {
        return sysOut;
      } else if (fieldName.equals("in")) {
        return sysIn;
      } else if (fieldName.equals("err")) {
        return sysErr;
      }
    }

    throw new IllegalArgumentException(String.format("Field %s not set for class %s", field, getDeclaringClass()));
  }
}
