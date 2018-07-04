package de.upb.soot.jimple.interpreter.buildins;

import de.upb.soot.jimple.interpreter.Environment;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;

import soot.Body;
import soot.Context;
import soot.MethodSource;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.tagkit.Host;
import soot.tagkit.Tag;
import soot.util.NumberedString;

/**
 * @author Manuel Benz created on 03.07.18
 */
public abstract class MethodDelegate extends SootMethod {

  private final SootMethod original;

  public MethodDelegate(SootMethod orig) {
    super(orig.getName(), orig.getParameterTypes(), orig.getReturnType(), orig.getModifiers(), orig.getExceptions());
    this.original = orig;
  }

  /**
   * Creates a MethodDelegate that executes the given SootMethod on the given Java! instance object via reflection.
   * 
   * @param method
   * @param instance
   * @return
   */
  public static MethodDelegate instanceInvokeDelegate(SootMethod method, Object instance) {
    return new MethodDelegate(method) {
      @Override
      public Object delegate(Environment env) {
        try {
          final Method declaredMethod = instance.getClass().getDeclaredMethod(method.getName(), getJavaParams());
          // this only works for primitive types and string constants. we cannot convert a JObject to its Java
          // representation
          return declaredMethod.invoke(instance, env.getMethodArguments());
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    };
  }

  public abstract Object delegate(Environment env);

  protected Class[] getJavaParams() {
    Class[] res = new Class[getParameterCount()];
    final List<Type> parameterTypes = getParameterTypes();
    for (int i = 0; i < parameterTypes.size(); i++) {
      final Type type = parameterTypes.get(i);

      try {
        res[i] = ClassUtils.getClass(type.toString());
      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      }
    }
    return res;
  }

  @Override
  public MethodSource getSource() {
    return original.getSource();
  }

  @Override
  public void setSource(MethodSource ms) {
    original.setSource(ms);
  }

  @Override
  public int equivHashCode() {
    return original.equivHashCode();
  }

  @Override
  public String getName() {
    if (original == null) {
      return super.getName();
    }
    return original.getName();
  }

  @Override
  public void setName(String name) {
    original.setName(name);
  }

  @Override
  public SootClass getDeclaringClass() {
    return original.getDeclaringClass();
  }

  @Override
  public void setDeclaringClass(SootClass declClass) {
    original.setDeclaringClass(declClass);
  }

  @Override
  public boolean isDeclared() {
    return original.isDeclared();
  }

  @Override
  public void setDeclared(boolean isDeclared) {
    original.setDeclared(isDeclared);
  }

  @Override
  public boolean isPhantom() {
    return original.isPhantom();
  }

  @Override
  public void setPhantom(boolean value) {
    original.setPhantom(value);
  }

  @Override
  public boolean isConcrete() {
    return original.isConcrete();
  }

  @Override
  public int getModifiers() {
    return original.getModifiers();
  }

  @Override
  public void setModifiers(int modifiers) {
    original.setModifiers(modifiers);
  }

  @Override
  public Type getReturnType() {
    if (original == null) {
      return super.getReturnType();
    }
    return original.getReturnType();
  }

  @Override
  public void setReturnType(Type t) {
    original.setReturnType(t);
  }

  @Override
  public int getParameterCount() {
    return original.getParameterCount();
  }

  @Override
  public Type getParameterType(int n) {
    return original.getParameterType(n);
  }

  @Override
  public List<Type> getParameterTypes() {
    if (original == null) {
      return super.getParameterTypes();
    }
    return original.getParameterTypes();
  }

  @Override
  public void setParameterTypes(List<Type> l) {
    original.setParameterTypes(l);
  }

  @Override
  public Body getActiveBody() {
    return original.getActiveBody();
  }

  @Override
  public void setActiveBody(Body body) {
    original.setActiveBody(body);
  }

  @Override
  public Body retrieveActiveBody() {
    return original.retrieveActiveBody();
  }

  @Override
  public boolean hasActiveBody() {
    return original.hasActiveBody();
  }

  @Override
  public void releaseActiveBody() {
    original.releaseActiveBody();
  }

  @Override
  public void addExceptionIfAbsent(SootClass e) {
    original.addExceptionIfAbsent(e);
  }

  @Override
  public void addException(SootClass e) {
    original.addException(e);
  }

  @Override
  public void removeException(SootClass e) {
    original.removeException(e);
  }

  @Override
  public boolean throwsException(SootClass e) {
    return original.throwsException(e);
  }

  @Override
  public List<SootClass> getExceptions() {
    return original.getExceptions();
  }

  @Override
  public void setExceptions(List<SootClass> exceptions) {
    original.setExceptions(exceptions);
  }

  @Override
  public List<SootClass> getExceptionsUnsafe() {
    return original.getExceptionsUnsafe();
  }

  @Override
  public boolean isStatic() {
    return original.isStatic();
  }

  @Override
  public boolean isPrivate() {
    return original.isPrivate();
  }

  @Override
  public boolean isPublic() {
    return original.isPublic();
  }

  @Override
  public boolean isProtected() {
    return original.isProtected();
  }

  @Override
  public boolean isAbstract() {
    return original.isAbstract();
  }

  @Override
  public boolean isFinal() {
    return original.isFinal();
  }

  @Override
  public boolean isNative() {
    return original.isNative();
  }

  @Override
  public boolean isSynchronized() {
    return original.isSynchronized();
  }

  @Override
  public boolean isMain() {
    return original.isMain();
  }

  @Override
  public boolean isConstructor() {
    return original.isConstructor();
  }

  @Override
  public boolean isStaticInitializer() {
    return original.isStaticInitializer();
  }

  @Override
  public boolean isEntryMethod() {
    return original.isEntryMethod();
  }

  @Override
  public boolean isJavaLibraryMethod() {
    return original.isJavaLibraryMethod();
  }

  @Override
  public String getBytecodeParms() {
    return original.getBytecodeParms();
  }

  @Override
  public String getBytecodeSignature() {
    return original.getBytecodeSignature();
  }

  @Override
  public String getSignature() {
    return original.getSignature();
  }

  @Override
  public String getSubSignature() {
    if (original == null) {
      return super.getSubSignature();
    }
    return original.getSubSignature();
  }

  @Override
  public NumberedString getNumberedSubSignature() {
    return original.getNumberedSubSignature();
  }

  @Override
  public String toString() {
    return original.toString();
  }

  @Override
  public String getDavaDeclaration() {
    return original.getDavaDeclaration();
  }

  @Override
  public String getDeclaration() {
    return original.getDeclaration();
  }

  @Override
  public SootMethod method() {
    return original.method();
  }

  @Override
  public Context context() {
    return original.context();
  }

  @Override
  public SootMethodRef makeRef() {
    return original.makeRef();
  }

  @Override
  public int getJavaSourceStartLineNumber() {
    return original.getJavaSourceStartLineNumber();
  }

  @Override
  public List<Tag> getTags() {
    return original.getTags();
  }

  @Override
  public void removeTag(String aName) {
    original.removeTag(aName);
  }

  @Override
  public Tag getTag(String aName) {
    return original.getTag(aName);
  }

  @Override
  public boolean hasTag(String aName) {
    return original.hasTag(aName);
  }

  @Override
  public void addTag(Tag t) {
    original.addTag(t);
  }

  @Override
  public void removeAllTags() {
    original.removeAllTags();
  }

  @Override
  public void addAllTagsOf(Host h) {
    original.addAllTagsOf(h);
  }

  @Override
  public int getJavaSourceStartColumnNumber() {
    return original.getJavaSourceStartColumnNumber();
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
