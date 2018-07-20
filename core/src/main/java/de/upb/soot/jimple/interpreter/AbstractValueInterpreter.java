package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.values.JClassConstant;
import de.upb.soot.jimple.interpreter.values.JClassObject;
import de.upb.soot.jimple.interpreter.values.JObject;

import org.jboss.util.NotImplementedException;

import soot.Local;
import soot.RefType;
import soot.SootField;
import soot.SootMethod;
import soot.Value;
import soot.jimple.AbstractJimpleValueSwitch;
import soot.jimple.ArrayRef;
import soot.jimple.CastExpr;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.ClassConstant;
import soot.jimple.DoubleConstant;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.FloatConstant;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InstanceOfExpr;
import soot.jimple.IntConstant;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.LengthExpr;
import soot.jimple.LongConstant;
import soot.jimple.MethodHandle;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.NullConstant;
import soot.jimple.ParameterRef;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.StringConstant;
import soot.jimple.ThisRef;
import soot.jimple.VirtualInvokeExpr;

/**
 * @author Manuel Benz created on 29.06.18
 */
public abstract class AbstractValueInterpreter extends AbstractJimpleValueSwitch {
  protected final JimpleInterpreter jimpleInterpreter;
  protected final ClassRegistry classRegistry;
  protected SootMethod curMethod;
  protected Environment curEnvironment;

  public AbstractValueInterpreter(JimpleInterpreter jimpleInterpreter) {
    this.jimpleInterpreter = jimpleInterpreter;
    this.classRegistry = jimpleInterpreter.getClassRegistry();
  }

  @Override
  public void defaultCase(Object obj) {
    throw new NotImplementedException(String.format("%s expression not supported", obj));
  }

  protected void setCurMethod(SootMethod curMethod) {
    this.curMethod = curMethod;
  }

  protected void setCurEnvironment(Environment curEnvironment) {
    this.curEnvironment = curEnvironment;
  }

  // # Common interpretation behavior between concrete and symbolic

  @Override
  public void caseArrayRef(ArrayRef v) {
    super.caseArrayRef(v);
  }

  @Override
  public void caseInterfaceInvokeExpr(InterfaceInvokeExpr v) {
    super.caseInterfaceInvokeExpr(v);
  }

  @Override
  public void caseStaticInvokeExpr(StaticInvokeExpr v) {
    final SootMethod methodToCall = v.getMethod();
    final JClassObject classObject = classRegistry.getClassObject(curEnvironment, methodToCall.getDeclaringClass());
    final Object result = jimpleInterpreter.interpret(classObject.getMethod(methodToCall, false),
        curEnvironment.createChild(classObject, mapArguments(v)));
    setResult(result);
  }

  /**
   * Returns the actual-argument list extreacted from curEnvironment that corresponds to the invoke-expression v.
   */
  private Object[] mapArguments(InvokeExpr v) {
    Object[] args = new Object[v.getArgCount()];

    for (int i = 0; i < args.length; i++) {
      v.getArg(i).apply(this);
      final Object argval = getResult();
      args[i] = argval;
    }
    return args;
  }

  @Override
  public void caseSpecialInvokeExpr(SpecialInvokeExpr v) {
    caseInstanceInvokeExpr(v, false /* no virtual resolution */);
  }

  @Override
  public void caseVirtualInvokeExpr(VirtualInvokeExpr v) {
    caseInstanceInvokeExpr(v, true);
  }

  private void caseInstanceInvokeExpr(InstanceInvokeExpr v, boolean virtualCall) {
    v.getBase().apply(this);
    final Object base = getResult();

    if (!(base instanceof JObject)) {
      interpretException(v, String.format("Base object of virtual invoke not an object type (obj: %s).", base));
    }

    final JObject jbaseObject = (JObject) base;
    final Environment environment = curEnvironment.createChild(jbaseObject, mapArguments(v));
    final Object result = jimpleInterpreter.interpret(jbaseObject.getMethod(v.getMethod(), virtualCall), environment);
    setResult(result);
  }

  @Override
  public void caseDynamicInvokeExpr(DynamicInvokeExpr v) {
    super.caseDynamicInvokeExpr(v);
  }

  @Override
  public void caseCastExpr(CastExpr v) {
    v.getOp().apply(this);
    final Object val = getResult();
    if (val instanceof JObject) {
      JObject casted = ((JObject) val).castTo(v.getCastType());
      setResult(casted);
    } else {
      setResult(Utils.castJavaObjectToType(val, v.getCastType()));
    }

  }

  @Override
  public void caseInstanceOfExpr(InstanceOfExpr v) {
    v.getOp().apply(this);
    final Object object = getResult();
    if (object instanceof JObject) {
      setResult(((JObject) object).instanceOf(v.getCheckType()));
    } else if (object instanceof String) {
      // its a string constant
      setResult(v.getCheckType().equals(RefType.v("java.lang.String")));
    } else {
      defaultCase(v);
    }
  }

  @Override
  public void caseNewArrayExpr(NewArrayExpr v) {
    super.caseNewArrayExpr(v);
  }

  @Override
  public void caseNewMultiArrayExpr(NewMultiArrayExpr v) {
    super.caseNewMultiArrayExpr(v);
  }

  @Override
  public void caseNewExpr(NewExpr v) {
    final JClassObject clazzObj = classRegistry.getClassObject(curEnvironment, v.getBaseType().getSootClass());
    setResult(clazzObj.newInstance());
  }

  @Override
  public void caseLengthExpr(LengthExpr v) {
    super.caseLengthExpr(v);
  }

  @Override
  public void caseInstanceFieldRef(InstanceFieldRef v) {
    v.getBase().apply(this);
    final JObject object = (JObject) getResult();
    final Object val = object.getFieldValue(v.getField());
    setResult(val);
  }

  @Override
  public void caseLocal(Local v) {
    setResult(curEnvironment.getLocalValue(v));
  }

  @Override
  public void caseParameterRef(ParameterRef v) {
    super.caseParameterRef(v);
  }

  @Override
  public void caseCaughtExceptionRef(CaughtExceptionRef v) {
    super.caseCaughtExceptionRef(v);
  }

  @Override
  public void caseThisRef(ThisRef v) {
    final JObject thisInstance = curEnvironment.getThisInstance();
    if (thisInstance == null) {
      interpretException(v, "This pointer reference where this-instance not set");
    }
    setResult(thisInstance);
  }

  @Override
  public void caseStaticFieldRef(StaticFieldRef v) {
    final SootField field = v.getField();
    final JClassObject classObject = classRegistry.getClassObject(curEnvironment, field.getDeclaringClass());
    final Object fieldValue = classObject.getFieldValue(field);
    setResult(fieldValue);
  }

  @Override
  public void caseDoubleConstant(DoubleConstant v) {
    setResult(v.value);
  }

  @Override
  public void caseFloatConstant(FloatConstant v) {
    setResult(v.value);
  }

  @Override
  public void caseIntConstant(IntConstant v) {
    setResult(v.value);
  }

  @Override
  public void caseLongConstant(LongConstant v) {
    setResult(v.value);
  }

  @Override
  public void caseNullConstant(NullConstant v) {
    // TODO will null work here?
    setResult(null);
  }

  @Override
  public void caseStringConstant(StringConstant v) {
    setResult(v.value);
  }

  @Override
  public void caseClassConstant(ClassConstant v) {
    // we cannot use class for name here since we might not have the class in our classpath
    setResult(new JClassConstant(v));
  }

  @Override
  public void caseMethodHandle(MethodHandle v) {
    super.caseMethodHandle(v);
  }
  // end

  protected void interpretException(Value v, final String msg) {
    throw new IllegalStateException(String.format("%s Method: %s, Value: %s", msg, curMethod, v));
  }

  public void reset() {
    curEnvironment = null;
    curMethod = null;
  }
}
