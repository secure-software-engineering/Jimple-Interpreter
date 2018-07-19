package de.upb.soot.jimple.interpreter;

import org.jboss.util.NotImplementedException;

import soot.ByteType;
import soot.DoubleType;
import soot.FloatType;
import soot.IntType;
import soot.LongType;
import soot.ShortType;
import soot.Type;

/**
 * @author Manuel Benz created on 19.07.18
 */
public class Utils {

  public static Class<?> jimpleTypeToJavaClass(Type jimpleType) {
    if (jimpleType.equals(IntType.v())) {
      return Integer.class;
    } else if (jimpleType.equals(LongType.v())) {
      return Long.class;
    } else if (jimpleType.equals(ShortType.v())) {
      return Short.class;
    } else if (jimpleType.equals(FloatType.v())) {
      return Float.class;
    } else if (jimpleType.equals(DoubleType.v())) {
      return Double.class;
    } else if (jimpleType.equals(ByteType.v())) {
      return Byte.class;
    } else {
      throw new NotImplementedException("Type not supported: " + jimpleType);
    }

  }
}
