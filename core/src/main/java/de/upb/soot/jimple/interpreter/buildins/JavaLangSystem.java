package de.upb.soot.jimple.interpreter.buildins;

import de.upb.soot.jimple.interpreter.Environment;
import de.upb.soot.jimple.interpreter.values.JClassObject;
import de.upb.soot.jimple.interpreter.values.JObject;

import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

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
        return new MethodDelegate(method) {
          @Override
          public Object delegate(Environment env) {
            try {
              final Method declaredMethod = outputStream.getClass().getDeclaredMethod(method.getName(), getJavaParams());
              // this only works for primitive types and string constants. we cannot convert a JObject to its Java
              // representation
              return declaredMethod.invoke(outputStream, env.getMethodArguments());
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
          }
        };
      }
    };

    sysErr = new JObject(Scene.v().getSootClass("java.io.PrintStream")) {
      @Override
      public SootMethod getMethod(SootMethod method) {
        return null;
      }
    };

    sysIn = new JObject(Scene.v().getSootClass("java.io.InputStream")) {
      @Override
      public SootMethod getMethod(SootMethod method) {
        return null;
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
