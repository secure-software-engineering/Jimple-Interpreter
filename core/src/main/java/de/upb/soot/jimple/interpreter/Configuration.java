package de.upb.soot.jimple.interpreter;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class Configuration {

  private final String classPath;
  private PrintStream outputStream = System.out;
  private InputStream inputStream = System.in;
  private PrintStream errorStream = System.err;
  private boolean reuseSoot = false;

  public Configuration(String classPath) {
    this.classPath = classPath;
  }

  public PrintStream getOutputStream() {
    return outputStream;
  }

  public void setOutputStream(PrintStream outputStream) {
    this.outputStream = outputStream;
  }

  public InputStream getInputStream() {
    return inputStream;
  }

  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  public PrintStream getErrorStream() {
    return errorStream;
  }

  public void setErrorStream(PrintStream errorStream) {
    this.errorStream = errorStream;
  }

  public boolean getUseExistingSootInstance() {
    return reuseSoot;
  }

  public void setReuseSoot(boolean reuseSoot) {
    this.reuseSoot = reuseSoot;
  }

  public String getClassPath() {
    return classPath;
  }
}
