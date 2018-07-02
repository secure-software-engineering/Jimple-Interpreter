package de.upb.soot.jimple.interpreter;

import org.jboss.util.NotImplementedException;

import soot.Local;
import soot.SootMethod;
import soot.jimple.AbstractJimpleValueSwitch;
import soot.jimple.ArrayRef;
import soot.jimple.CastExpr;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.ClassConstant;
import soot.jimple.DoubleConstant;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.FloatConstant;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceOfExpr;
import soot.jimple.IntConstant;
import soot.jimple.InterfaceInvokeExpr;
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
public abstract class AbstractValueInterpreter extends AbstractJimpleValueSwitch<IValue> {
  private final JimpleInterpreter jimpleInterpreter;
  private SootMethod curMethod;
  private Environment curEnvironment;

  public AbstractValueInterpreter(JimpleInterpreter jimpleInterpreter) {
    this.jimpleInterpreter = jimpleInterpreter;
  }

  @Override
  public void defaultCase(Object obj) {
    throw new NotImplementedException(String.format("%s expression not supported", obj));
  }

  public SootMethod getCurMethod() {
    return curMethod;
  }

  protected void setCurMethod(SootMethod curMethod) {
    this.curMethod = curMethod;
  }

  public Environment getCurEnvironment() {
    return curEnvironment;
  }

  protected void setCurEnvironment(Environment curEnvironment) {
    this.curEnvironment = curEnvironment;
  }

  // # Common interpretation behavior between concrete and symbolic

  @Override public void caseArrayRef(ArrayRef v) {
    super.caseArrayRef(v);
  }

  @Override public void caseInterfaceInvokeExpr(InterfaceInvokeExpr v) {
    super.caseInterfaceInvokeExpr(v);
  }

  @Override public void caseSpecialInvokeExpr(SpecialInvokeExpr v) {
    super.caseSpecialInvokeExpr(v);
  }

  @Override public void caseStaticInvokeExpr(StaticInvokeExpr v) {
    super.caseStaticInvokeExpr(v);
  }

  @Override public void caseVirtualInvokeExpr(VirtualInvokeExpr v) {
    super.caseVirtualInvokeExpr(v);
  }

  @Override public void caseDynamicInvokeExpr(DynamicInvokeExpr v) {
    super.caseDynamicInvokeExpr(v);
  }

  @Override public void caseCastExpr(CastExpr v) {
    super.caseCastExpr(v);
  }

  @Override public void caseInstanceOfExpr(InstanceOfExpr v) {
    super.caseInstanceOfExpr(v);
  }

  @Override public void caseNewArrayExpr(NewArrayExpr v) {
    super.caseNewArrayExpr(v);
  }

  @Override public void caseNewMultiArrayExpr(NewMultiArrayExpr v) {
    super.caseNewMultiArrayExpr(v);
  }

  @Override public void caseNewExpr(NewExpr v) {
    super.caseNewExpr(v);
  }

  @Override public void caseLengthExpr(LengthExpr v) {
    super.caseLengthExpr(v);
  }

  @Override public void caseInstanceFieldRef(InstanceFieldRef v) {
    super.caseInstanceFieldRef(v);
  }

  @Override public void caseLocal(Local v) {
    super.caseLocal(v);
  }

  @Override public void caseParameterRef(ParameterRef v) {
    super.caseParameterRef(v);
  }

  @Override public void caseCaughtExceptionRef(CaughtExceptionRef v) {
    super.caseCaughtExceptionRef(v);
  }

  @Override public void caseThisRef(ThisRef v) {
    super.caseThisRef(v);
  }

  @Override public void caseStaticFieldRef(StaticFieldRef v) {
    super.caseStaticFieldRef(v);
  }

  @Override public void caseDoubleConstant(DoubleConstant v) {
    super.caseDoubleConstant(v);
  }

  @Override public void caseFloatConstant(FloatConstant v) {
    super.caseFloatConstant(v);
  }

  @Override public void caseIntConstant(IntConstant v) {
    super.caseIntConstant(v);
  }

  @Override public void caseLongConstant(LongConstant v) {
    super.caseLongConstant(v);
  }

  @Override public void caseNullConstant(NullConstant v) {
    super.caseNullConstant(v);
  }

  @Override public void caseStringConstant(StringConstant v) {
    super.caseStringConstant(v);
  }

  @Override public void caseClassConstant(ClassConstant v) {
    super.caseClassConstant(v);
  }

  @Override public void caseMethodHandle(MethodHandle v) {
    super.caseMethodHandle(v);
  }

  // end

}
