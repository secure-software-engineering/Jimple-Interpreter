package de.upb.soot.jimple.interpreter.concrete;

import de.upb.soot.jimple.interpreter.AbstractValueInterpreter;

import soot.Local;
import soot.jimple.AddExpr;
import soot.jimple.AndExpr;
import soot.jimple.ArrayRef;
import soot.jimple.CastExpr;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.ClassConstant;
import soot.jimple.CmpExpr;
import soot.jimple.CmpgExpr;
import soot.jimple.CmplExpr;
import soot.jimple.DivExpr;
import soot.jimple.DoubleConstant;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.EqExpr;
import soot.jimple.FloatConstant;
import soot.jimple.GeExpr;
import soot.jimple.GtExpr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceOfExpr;
import soot.jimple.IntConstant;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.LeExpr;
import soot.jimple.LengthExpr;
import soot.jimple.LongConstant;
import soot.jimple.LtExpr;
import soot.jimple.MethodHandle;
import soot.jimple.MulExpr;
import soot.jimple.NeExpr;
import soot.jimple.NegExpr;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.NullConstant;
import soot.jimple.OrExpr;
import soot.jimple.ParameterRef;
import soot.jimple.RemExpr;
import soot.jimple.ShlExpr;
import soot.jimple.ShrExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.StringConstant;
import soot.jimple.SubExpr;
import soot.jimple.ThisRef;
import soot.jimple.UshrExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.XorExpr;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class ConcreteValueInterpreter extends AbstractValueInterpreter {
  @Override public void caseArrayRef(ArrayRef v) {
    super.caseArrayRef(v);
  }

  @Override public void caseAddExpr(AddExpr v) {
    super.caseAddExpr(v);
  }

  @Override public void caseAndExpr(AndExpr v) {
    super.caseAndExpr(v);
  }

  @Override public void caseCmpExpr(CmpExpr v) {
    super.caseCmpExpr(v);
  }

  @Override public void caseCmpgExpr(CmpgExpr v) {
    super.caseCmpgExpr(v);
  }

  @Override public void caseCmplExpr(CmplExpr v) {
    super.caseCmplExpr(v);
  }

  @Override public void caseDivExpr(DivExpr v) {
    super.caseDivExpr(v);
  }

  @Override public void caseEqExpr(EqExpr v) {
    super.caseEqExpr(v);
  }

  @Override public void caseGeExpr(GeExpr v) {
    super.caseGeExpr(v);
  }

  @Override public void caseGtExpr(GtExpr v) {
    super.caseGtExpr(v);
  }

  @Override public void caseLeExpr(LeExpr v) {
    super.caseLeExpr(v);
  }

  @Override public void caseLtExpr(LtExpr v) {
    super.caseLtExpr(v);
  }

  @Override public void caseMulExpr(MulExpr v) {
    super.caseMulExpr(v);
  }

  @Override public void caseNeExpr(NeExpr v) {
    super.caseNeExpr(v);
  }

  @Override public void caseOrExpr(OrExpr v) {
    super.caseOrExpr(v);
  }

  @Override public void caseRemExpr(RemExpr v) {
    super.caseRemExpr(v);
  }

  @Override public void caseShlExpr(ShlExpr v) {
    super.caseShlExpr(v);
  }

  @Override public void caseShrExpr(ShrExpr v) {
    super.caseShrExpr(v);
  }

  @Override public void caseSubExpr(SubExpr v) {
    super.caseSubExpr(v);
  }

  @Override public void caseUshrExpr(UshrExpr v) {
    super.caseUshrExpr(v);
  }

  @Override public void caseXorExpr(XorExpr v) {
    super.caseXorExpr(v);
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

  @Override public void caseNegExpr(NegExpr v) {
    super.caseNegExpr(v);
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
}
