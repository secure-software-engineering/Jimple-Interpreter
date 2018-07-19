package de.upb.soot.jimple.interpreter.concrete;

import de.upb.soot.jimple.interpreter.AbstractValueInterpreter;
import de.upb.soot.jimple.interpreter.JimpleInterpreter;
import de.upb.soot.jimple.interpreter.Utils;

import soot.DoubleType;
import soot.FloatType;
import soot.LongType;
import soot.Type;
import soot.Value;
import soot.jimple.AddExpr;
import soot.jimple.AndExpr;
import soot.jimple.BinopExpr;
import soot.jimple.CmpExpr;
import soot.jimple.CmpgExpr;
import soot.jimple.CmplExpr;
import soot.jimple.DivExpr;
import soot.jimple.EqExpr;
import soot.jimple.GeExpr;
import soot.jimple.GtExpr;
import soot.jimple.LeExpr;
import soot.jimple.LtExpr;
import soot.jimple.MulExpr;
import soot.jimple.NeExpr;
import soot.jimple.NegExpr;
import soot.jimple.OrExpr;
import soot.jimple.RemExpr;
import soot.jimple.ShlExpr;
import soot.jimple.ShrExpr;
import soot.jimple.SubExpr;
import soot.jimple.UshrExpr;
import soot.jimple.XorExpr;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class ConcreteValueInterpreter extends AbstractValueInterpreter {
  public ConcreteValueInterpreter(JimpleInterpreter jimpleInterpreter) {
    super(jimpleInterpreter);
  }

  @Override
  public void caseAddExpr(AddExpr v) {

    evalNumericBinOp(v, new BinOpInterpreter() {
      @Override
      protected long applyLong(Long a, Long b) {
        return a + b;
      }

      @Override
      protected int applyInteger(Integer a, Integer b) {
        return a + b;
      }

      @Override
      protected float applyFloat(Float a, Float b) {
        return a + b;
      }

      @Override
      protected double applyDouble(Double a, Double b) {
        return a + b;
      }
    });

  }

  @Override
  public void caseAndExpr(AndExpr v) {
    super.caseAndExpr(v);
  }

  @Override
  public void caseCmpExpr(CmpExpr v) {
    super.caseCmpExpr(v);
  }

  @Override
  public void caseCmpgExpr(CmpgExpr v) {
    super.caseCmpgExpr(v);
  }

  @Override
  public void caseCmplExpr(CmplExpr v) {
    super.caseCmplExpr(v);
  }

  @Override
  public void caseDivExpr(DivExpr v) {
    super.caseDivExpr(v);
  }

  @Override
  public void caseEqExpr(EqExpr v) {
    super.caseEqExpr(v);
  }

  @Override
  public void caseGeExpr(GeExpr v) {
    super.caseGeExpr(v);
  }

  @Override
  public void caseGtExpr(GtExpr v) {
    super.caseGtExpr(v);
  }

  @Override
  public void caseLeExpr(LeExpr v) {
    super.caseLeExpr(v);
  }

  @Override
  public void caseLtExpr(LtExpr v) {
    super.caseLtExpr(v);
  }

  @Override
  public void caseMulExpr(MulExpr v) {
    super.caseMulExpr(v);
  }

  @Override
  public void caseNeExpr(NeExpr v) {
    super.caseNeExpr(v);
  }

  @Override
  public void caseOrExpr(OrExpr v) {
    super.caseOrExpr(v);
  }

  @Override
  public void caseRemExpr(RemExpr v) {
    super.caseRemExpr(v);
  }

  @Override
  public void caseShlExpr(ShlExpr v) {
    super.caseShlExpr(v);
  }

  @Override
  public void caseShrExpr(ShrExpr v) {
    super.caseShrExpr(v);
  }

  @Override
  public void caseSubExpr(SubExpr v) {
    super.caseSubExpr(v);
  }

  @Override
  public void caseUshrExpr(UshrExpr v) {
    super.caseUshrExpr(v);
  }

  @Override
  public void caseXorExpr(XorExpr v) {
    super.caseXorExpr(v);
  }

  @Override
  public void caseNegExpr(NegExpr v) {
    super.caseNegExpr(v);
  }

  private void evalNumericBinOp(BinopExpr v, BinOpInterpreter op) {
    final Value leftOp = v.getOp1();
    leftOp.apply(this);
    final Object leftVal = getResult();

    final Value rightOp = v.getOp2();
    rightOp.apply(this);
    final Object rightVal = getResult();

    final Type resultType = v.getType();
    final Type leftType = leftOp.getType();
    final Type rightType = rightOp.getType();

    /*
     * We use binary number promotion to fit the parameter types of the operands
     * https://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.6.2
     */
    if (leftType.equals(DoubleType.v()) || rightType.equals(DoubleType.v())) {
      setResult(Utils.castJavaObjectToType(op.applyDouble((Double) leftVal, (Double) rightVal), resultType));
    } else if (leftType.equals(FloatType.v()) || rightType.equals(FloatType.v())) {
      setResult(Utils.castJavaObjectToType(op.applyFloat((Float) leftVal, (Float) rightVal), resultType));
    } else if (leftType.equals(LongType.v()) || rightType.equals(LongType.v())) {
      setResult(Utils.castJavaObjectToType(op.applyLong((Long) leftVal, (Long) rightVal), resultType));
    } else {
      setResult(Utils.castJavaObjectToType(op.applyInteger((Integer) leftVal, (Integer) rightVal), resultType));
    }
  }

}
