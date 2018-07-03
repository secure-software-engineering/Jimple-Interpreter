package soot;

import java.util.Iterator;
import java.util.List;

import soot.tagkit.Host;
import soot.tagkit.Tag;
import soot.util.Chain;
import soot.util.NumberedString;
import soot.validation.ValidationException;

/**
 * @author Manuel Benz created on 02.07.18
 */
public class SootClassDelegate extends SootClass {

  private final SootClass original;

  public SootClassDelegate(SootClass original) {
    super(original.getName());
    this.original = original;
  }

  @Override
  public void initializeRefType(String name) {
    original.initializeRefType(name);
  }

  @Override
  public String levelToString(int level) {
    return original.levelToString(level);
  }

  @Override
  public void checkLevel(int level) {
    original.checkLevel(level);
  }

  @Override
  public void checkLevelIgnoreResolving(int level) {
    original.checkLevelIgnoreResolving(level);
  }

  @Override
  public int resolvingLevel() {
    return original.resolvingLevel();
  }

  @Override
  public void setResolvingLevel(int newLevel) {
    original.setResolvingLevel(newLevel);
  }

  @Override
  public boolean isInScene() {
    return original.isInScene();
  }

  @Override
  public void setInScene(boolean isInScene) {
    original.setInScene(isInScene);
  }

  @Override
  public int getFieldCount() {
    return original.getFieldCount();
  }

  @Override
  public Chain<SootField> getFields() {
    return original.getFields();
  }

  @Override
  public void addField(SootField f) {
    original.addField(f);
  }

  @Override
  public void removeField(SootField f) {
    original.removeField(f);
  }

  @Override
  public SootField getField(String name, Type type) {
    return original.getField(name, type);
  }

  @Override
  public SootField getFieldUnsafe(String name, Type type) {
    return original.getFieldUnsafe(name, type);
  }

  @Override
  public SootField getFieldByName(String name) {
    return original.getFieldByName(name);
  }

  @Override
  public SootField getFieldByNameUnsafe(String name) {
    return original.getFieldByNameUnsafe(name);
  }

  @Override
  public SootField getField(String subsignature) {
    return original.getField(subsignature);
  }

  @Override
  public SootField getFieldUnsafe(String subsignature) {
    return original.getFieldUnsafe(subsignature);
  }

  @Override
  public boolean declaresField(String subsignature) {
    return original.declaresField(subsignature);
  }

  @Override
  public SootMethod getMethod(NumberedString subsignature) {
    return original.getMethod(subsignature);
  }

  @Override
  public SootMethod getMethodUnsafe(NumberedString subsignature) {
    return original.getMethodUnsafe(subsignature);
  }

  @Override
  public boolean declaresMethod(NumberedString subsignature) {
    return original.declaresMethod(subsignature);
  }

  @Override
  public SootMethod getMethod(String subsignature) {
    return original.getMethod(subsignature);
  }

  @Override
  public SootMethod getMethodUnsafe(String subsignature) {
    return original.getMethodUnsafe(subsignature);
  }

  @Override
  public boolean declaresMethod(String subsignature) {
    return original.declaresMethod(subsignature);
  }

  @Override
  public boolean declaresFieldByName(String name) {
    return original.declaresFieldByName(name);
  }

  @Override
  public boolean declaresField(String name, Type type) {
    return original.declaresField(name, type);
  }

  @Override
  public int getMethodCount() {
    return original.getMethodCount();
  }

  @Override
  public Iterator<SootMethod> methodIterator() {
    return original.methodIterator();
  }

  @Override
  public List<SootMethod> getMethods() {
    return original.getMethods();
  }

  @Override
  public SootMethod getMethod(String name, List<Type> parameterTypes, Type returnType) {
    return original.getMethod(name, parameterTypes, returnType);
  }

  @Override
  public SootMethod getMethodUnsafe(String name, List<Type> parameterTypes, Type returnType) {
    return original.getMethodUnsafe(name, parameterTypes, returnType);
  }

  @Override
  public SootMethod getMethod(String name, List<Type> parameterTypes) {
    return original.getMethod(name, parameterTypes);
  }

  @Override
  public SootMethod getMethodByNameUnsafe(String name) {
    return original.getMethodByNameUnsafe(name);
  }

  @Override
  public SootMethod getMethodByName(String name) {
    return original.getMethodByName(name);
  }

  @Override
  public boolean declaresMethod(String name, List<Type> parameterTypes) {
    return original.declaresMethod(name, parameterTypes);
  }

  @Override
  public boolean declaresMethod(String name, List<Type> parameterTypes, Type returnType) {
    return original.declaresMethod(name, parameterTypes, returnType);
  }

  @Override
  public boolean declaresMethodByName(String name) {
    return original.declaresMethodByName(name);
  }

  @Override
  public void addMethod(SootMethod m) {
    original.addMethod(m);
  }

  @Override
  public SootMethod getOrAddMethod(SootMethod m) {
    return original.getOrAddMethod(m);
  }

  @Override
  public SootField getOrAddField(SootField f) {
    return original.getOrAddField(f);
  }

  @Override
  public void removeMethod(SootMethod m) {
    original.removeMethod(m);
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
  public int getInterfaceCount() {
    return original.getInterfaceCount();
  }

  @Override
  public Chain<SootClass> getInterfaces() {
    return original.getInterfaces();
  }

  @Override
  public boolean implementsInterface(String name) {
    return original.implementsInterface(name);
  }

  @Override
  public void addInterface(SootClass interfaceClass) {
    original.addInterface(interfaceClass);
  }

  @Override
  public void removeInterface(SootClass interfaceClass) {
    original.removeInterface(interfaceClass);
  }

  @Override
  public boolean hasSuperclass() {
    return original.hasSuperclass();
  }

  @Override
  public SootClass getSuperclass() {
    return original.getSuperclass();
  }

  @Override
  public void setSuperclass(SootClass c) {
    original.setSuperclass(c);
  }

  @Override
  public SootClass getSuperclassUnsafe() {
    return original.getSuperclassUnsafe();
  }

  @Override
  public boolean hasOuterClass() {
    return original.hasOuterClass();
  }

  @Override
  public SootClass getOuterClass() {
    return original.getOuterClass();
  }

  @Override
  public void setOuterClass(SootClass c) {
    original.setOuterClass(c);
  }

  @Override
  public SootClass getOuterClassUnsafe() {
    return original.getOuterClassUnsafe();
  }

  @Override
  public boolean isInnerClass() {
    return original.isInnerClass();
  }

  @Override
  public String getName() {
    return original.getName();
  }

  @Override
  public void setName(String name) {
    original.setName(name);
  }

  @Override
  public String getJavaStyleName() {
    return original.getJavaStyleName();
  }

  @Override
  public String getShortJavaStyleName() {
    return original.getShortJavaStyleName();
  }

  @Override
  public String getShortName() {
    return original.getShortName();
  }

  @Override
  public String getPackageName() {
    return original.getPackageName();
  }

  @Override
  public String getJavaPackageName() {
    return original.getJavaPackageName();
  }

  @Override
  public boolean isInterface() {
    return original.isInterface();
  }

  @Override
  public boolean isEnum() {
    return original.isEnum();
  }

  @Override
  public boolean isSynchronized() {
    return original.isSynchronized();
  }

  @Override
  public boolean isConcrete() {
    return original.isConcrete();
  }

  @Override
  public boolean isPublic() {
    return original.isPublic();
  }

  @Override
  public boolean containsBafBody() {
    return original.containsBafBody();
  }

  @Override
  public void setRefType(RefType refType) {
    original.setRefType(refType);
  }

  @Override
  public boolean hasRefType() {
    return original.hasRefType();
  }

  @Override
  public RefType getType() {
    return original.getType();
  }

  @Override
  public String toString() {
    return original.toString();
  }

  @Override
  public void renameFieldsAndMethods(boolean privateOnly) {
    original.renameFieldsAndMethods(privateOnly);
  }

  @Override
  public boolean isApplicationClass() {
    return original.isApplicationClass();
  }

  @Override
  public void setApplicationClass() {
    original.setApplicationClass();
  }

  @Override
  public boolean isLibraryClass() {
    return original.isLibraryClass();
  }

  @Override
  public void setLibraryClass() {
    original.setLibraryClass();
  }

  @Override
  public boolean isJavaLibraryClass() {
    return original.isJavaLibraryClass();
  }

  @Override
  public boolean isPhantomClass() {
    return original.isPhantomClass();
  }

  @Override
  public void setPhantomClass() {
    original.setPhantomClass();
  }

  @Override
  public boolean isPhantom() {
    return original.isPhantom();
  }

  @Override
  public boolean isPrivate() {
    return original.isPrivate();
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
  public boolean isStatic() {
    return original.isStatic();
  }

  @Override
  public void setNumber(int number) {
    original.setNumber(number);
  }

  @Override
  public void rename(String newName) {
    original.rename(newName);
  }

  @Override
  public void validate() {
    original.validate();
  }

  @Override
  public void validate(List<ValidationException> exceptionList) {
    original.validate(exceptionList);
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
  public int getJavaSourceStartLineNumber() {
    return original.getJavaSourceStartLineNumber();
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
