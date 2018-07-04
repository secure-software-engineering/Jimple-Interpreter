package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.values.JClassObject;

import java.util.HashMap;

import soot.SootClass;
import soot.SootMethod;

/**
 * @author Manuel Benz created on 02.07.18
 */
public final class ClassRegistry {
  private final HashMap<SootClass, JClassObject> classes;
  private final JimpleInterpreter interpreter;

  protected ClassRegistry(JimpleInterpreter interpreter, JClassObject... buildIns) {
    this.interpreter = interpreter;
    this.classes = new HashMap<>();
    for (JClassObject buildIn : buildIns) {
      if (classes.put(buildIn.getDeclaringClass(), buildIn) != null) {
        throw new IllegalArgumentException("Build-in classes have to be unique");
      }
    }
  }

  public JClassObject getClassObject(SootClass clazz) {
    return classes.computeIfAbsent(clazz, c -> loadClass(c));
  }

  private JClassObject loadClass(SootClass clazz) {
    final JClassObject result = new JClassObject(clazz);
    final SootMethod clinit = clazz.getMethodByNameUnsafe(SootMethod.staticInitializerName);
    if (clinit == null) {
      // there is no clinit implemented for the class
      return result;
    }
    interpreter.interpret(clinit, new Environment(result));
    return result;
  }
}
