package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.buildins.JavaLangSystem;
import de.upb.soot.jimple.interpreter.values.JClassObject;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import soot.options.Options;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class Configuration {

  private final String classPath;
  private PrintStream outputStream = System.out;
  private InputStream inputStream = System.in;
  private PrintStream errorStream = System.err;
  private boolean reuseSoot = false;
  private boolean dumpJimple = false;
  private Consumer<Options> additionalSootOptions;
  private boolean clearJimpleOutDir = true;

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

  public boolean isReuseSoot() {
    return reuseSoot;
  }

  public void setReuseSoot(boolean reuseSoot) {
    this.reuseSoot = reuseSoot;
  }

  public String getClassPath() {
    return classPath;
  }

  public boolean isDumpJimple() {
    return dumpJimple;
  }

  public void setDumpJimple(boolean dumpJimple) {
    this.dumpJimple = dumpJimple;
  }

  public Consumer<Options> getAdditionalSootOptions() {
    return additionalSootOptions;
  }

  public void setAdditionalSootOptions(Consumer<Options> additionalOptions) {
    this.additionalSootOptions = additionalOptions;
  }

  public boolean isClearJimpleOutDir() {
    return clearJimpleOutDir;
  }

  public void setClearJimpleOutDir(boolean clearJimpleOutDir) {
    this.clearJimpleOutDir = clearJimpleOutDir;
  }

  public JClassObject[] getBuildIns() {
    // TODO we may allow for custom build-ins later on
    return new JClassObject[] { new JavaLangSystem(outputStream, errorStream, inputStream) };
  }
}
