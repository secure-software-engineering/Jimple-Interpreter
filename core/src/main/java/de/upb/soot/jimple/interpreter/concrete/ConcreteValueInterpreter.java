package de.upb.soot.jimple.interpreter.concrete;

import de.upb.soot.jimple.interpreter.AbstractValueInterpreter;
import de.upb.soot.jimple.interpreter.JimpleInterpreter;
import de.upb.soot.jimple.interpreter.Utils;

import org.apache.commons.lang3.BooleanUtils;

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
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Long applyLong(Long a, Long b) {
        return a + b;
      }

      @Override
      protected Integer applyInteger(Integer a, Integer b) {
        return a + b;
      }

      @Override
      protected Float applyFloat(Float a, Float b) {
        return a + b;
      }

      @Override
      protected Double applyDouble(Double a, Double b) {
        return a + b;
      }
    });

  }

  @Override
  public void caseSubExpr(SubExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Long applyLong(Long a, Long b) {
        return a - b;
      }

      @Override
      protected Integer applyInteger(Integer a, Integer b) {
        return a - b;
      }

      @Override
      protected Float applyFloat(Float a, Float b) {
        return a - b;
      }

      @Override
      protected Double applyDouble(Double a, Double b) {
        return a - b;
      }
    });
  }

  @Override
  public void caseMulExpr(MulExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Long applyLong(Long a, Long b) {
        return a * b;
      }

      @Override
      protected Integer applyInteger(Integer a, Integer b) {
        return a * b;
      }

      @Override
      protected Float applyFloat(Float a, Float b) {
        return a * b;
      }

      @Override
      protected Double applyDouble(Double a, Double b) {
        return a * b;
      }
    });
  }

  @Override
  public void caseDivExpr(DivExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Long applyLong(Long a, Long b) {
        return a / b;
      }

      @Override
      protected Integer applyInteger(Integer a, Integer b) {
        return a / b;
      }

      @Override
      protected Float applyFloat(Float a, Float b) {
        return a / b;
      }

      @Override
      protected Double applyDouble(Double a, Double b) {
        return a / b;
      }
    });
  }

  @Override
  public void caseAndExpr(AndExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Long applyLong(Long a, Long b) {
        return a & b;
      }

      @Override
      protected Integer applyInteger(Integer a, Integer b) {
        return a & b;
      }
    });
  }

  @Override
  public void caseCmpExpr(CmpExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Object applyLong(Long a, Long b) {
        return a == b;
      }

      @Override
      protected Object applyInteger(Integer a, Integer b) {
        return a == b;
      }

      @Override
      protected Object applyFloat(Float a, Float b) {
        return a == b;
      }

      @Override
      protected Object applyDouble(Double a, Double b) {
        return a == b;
      }
    });
  }

  @Override
  public void caseCmpgExpr(CmpgExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Boolean applyLong(Long a, Long b) {
        return a > b;
      }

      @Override
      protected Boolean applyInteger(Integer a, Integer b) {
        return a > b;
      }

      @Override
      protected Boolean applyFloat(Float a, Float b) {
        return a > b;
      }

      @Override
      protected Boolean applyDouble(Double a, Double b) {
        return a > b;
      }
    });
  }

  @Override
  public void caseCmplExpr(CmplExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Object applyLong(Long a, Long b) {
        return a < b;
      }

      @Override
      protected Object applyInteger(Integer a, Integer b) {
        return a < b;
      }

      @Override
      protected Object applyFloat(Float a, Float b) {
        return a < b;
      }

      @Override
      protected Object applyDouble(Double a, Double b) {
        return a < b;
      }
    });
  }

  @Override
  public void caseEqExpr(EqExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Object applyLong(Long a, Long b) {
        return a == b;
      }

      @Override
      protected Object applyInteger(Integer a, Integer b) {
        return a == b;
      }

      @Override
      protected Object applyFloat(Float a, Float b) {
        return a == b;
      }

      @Override
      protected Object applyDouble(Double a, Double b) {
        return a == b;
      }
    });
  }

  @Override
  public void caseGeExpr(GeExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Boolean applyLong(Long a, Long b) {
        return a >= b;
      }

      @Override
      protected Boolean applyInteger(Integer a, Integer b) {
        return a >= b;
      }

      @Override
      protected Boolean applyFloat(Float a, Float b) {
        return a >= b;
      }

      @Override
      protected Boolean applyDouble(Double a, Double b) {
        return a >= b;
      }
    });
  }

  @Override
  public void caseGtExpr(GtExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Boolean applyLong(Long a, Long b) {
        return a > b;
      }

      @Override
      protected Boolean applyInteger(Integer a, Integer b) {
        return a > b;
      }

      @Override
      protected Boolean applyFloat(Float a, Float b) {
        return a > b;
      }

      @Override
      protected Boolean applyDouble(Double a, Double b) {
        return a > b;
      }
    });
  }

  @Override
  public void caseLeExpr(LeExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Boolean applyLong(Long a, Long b) {
        return a <= b;
      }

      @Override
      protected Boolean applyInteger(Integer a, Integer b) {
        return a <= b;
      }

      @Override
      protected Boolean applyFloat(Float a, Float b) {
        return a <= b;
      }

      @Override
      protected Boolean applyDouble(Double a, Double b) {
        return a <= b;
      }
    });
  }

  @Override
  public void caseLtExpr(LtExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Boolean applyLong(Long a, Long b) {
        return a < b;
      }

      @Override
      protected Boolean applyInteger(Integer a, Integer b) {
        return a < b;
      }

      @Override
      protected Boolean applyFloat(Float a, Float b) {
        return a < b;
      }

      @Override
      protected Boolean applyDouble(Double a, Double b) {
        return a < b;
      }
    });
  }

  @Override
  public void caseNeExpr(NeExpr v) {

    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Boolean applyLong(Long a, Long b) {
        return a != b;
      }

      @Override
      protected Boolean applyInteger(Integer a, Integer b) {
        return a != b;
      }

      @Override
      protected Boolean applyFloat(Float a, Float b) {
        return a != b;
      }

      @Override
      protected Boolean applyDouble(Double a, Double b) {
        return a != b;
      }
    });
  }

  @Override
  public void caseOrExpr(OrExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Long applyLong(Long a, Long b) {
        return a | b;
      }

      @Override
      protected Integer applyInteger(Integer a, Integer b) {
        return a | b;
      }
    });
  }

  @Override
  public void caseRemExpr(RemExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Object applyLong(Long a, Long b) {
        return a % b;
      }

      @Override
      protected Object applyInteger(Integer a, Integer b) {
        return a % b;
      }

      @Override
      protected Object applyFloat(Float a, Float b) {
        return a % b;
      }

      @Override
      protected Object applyDouble(Double a, Double b) {
        return a % b;
      }
    });
  }

  @Override
  public void caseShlExpr(ShlExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Long applyLong(Long a, Long b) {
        return a << b;
      }

      @Override
      protected Integer applyInteger(Integer a, Integer b) {
        return a << b;
      }
    });
  }

  @Override
  public void caseShrExpr(ShrExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Long applyLong(Long a, Long b) {
        return a >> b;
      }

      @Override
      protected Integer applyInteger(Integer a, Integer b) {
        return a >> b;
      }
    });
  }

  @Override
  public void caseUshrExpr(UshrExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Long applyLong(Long a, Long b) {
        return a >>> b;
      }

      @Override
      protected Integer applyInteger(Integer a, Integer b) {
        return a >>> b;
      }
    });
  }

  @Override
  public void caseXorExpr(XorExpr v) {
    evalBinOp(v, new BinOpInterpreter() {
      @Override
      protected Long applyLong(Long a, Long b) {
        return a ^ b;
      }

      @Override
      protected Integer applyInteger(Integer a, Integer b) {
        return a ^ b;
      }
    });
  }

  @Override
  public void caseNegExpr(NegExpr v) {
    v.getOp().apply(this);
    final Object result = getResult();
    final Integer res = BooleanUtils.toIntegerObject(BooleanUtils.negate(BooleanUtils.toBoolean((Integer) result)));
    setResult(res);
  }

  private void evalBinOp(BinopExpr v, BinOpInterpreter op) {
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
      setResult(Utils.castJavaObjectToType(
          op.applyDouble(Utils.castJavaObject(leftVal, Double.class), Utils.castJavaObject(rightVal, Double.class)),
          resultType));
    } else if (leftType.equals(FloatType.v()) || rightType.equals(FloatType.v())) {
      setResult(Utils.castJavaObjectToType(
          op.applyFloat(Utils.castJavaObject(leftVal, Float.class), Utils.castJavaObject(rightVal, Float.class)),
          resultType));
    } else if (leftType.equals(LongType.v()) || rightType.equals(LongType.v())) {
      setResult(Utils.castJavaObjectToType(
          op.applyLong(Utils.castJavaObject(leftVal, Long.class), Utils.castJavaObject(rightVal, Long.class)), resultType));
    } else {
      setResult(Utils.castJavaObjectToType(
          op.applyInteger(Utils.castJavaObject(leftVal, Integer.class), Utils.castJavaObject(rightVal, Integer.class)),
          resultType));
    }
  }

}
