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
    registerBuildins(buildIns);
  }

  private void registerBuildins(JClassObject[] buildIns) {
    for (JClassObject buildIn : buildIns) {
      if (classes.put(buildIn.getDeclaringClass(), buildIn) != null) {
        throw new IllegalArgumentException("Build-in classes have to be unique");
      }
    }
  }

  public JClassObject getClassObject(Environment env, SootClass clazz) {
    JClassObject jClassObject = classes.get(clazz);
    if (jClassObject == null) {
      jClassObject = registerClass(env, clazz);
    }
    return jClassObject;
  }

  private JClassObject registerClass(Environment env, SootClass clazz) {
    final JClassObject result = new JClassObject(clazz);
    // we need to register the clazz object before calling clint since otherwise we will get an endless loop due to
    // recursivle resolving the same class if a static field of the same class is accessed in the initializer
    classes.put(clazz, result);
    final SootMethod clinit = clazz.getMethodByNameUnsafe(SootMethod.staticInitializerName);
    if (clinit == null) {
      // there is no clinit implemented for the class
      return result;
    }
    interpreter.interpret(clinit, env.createChild(result));
    return result;
  }

  public void reset(JClassObject... buildIns) {
    classes.clear();
    registerBuildins(buildIns);
  }
}
