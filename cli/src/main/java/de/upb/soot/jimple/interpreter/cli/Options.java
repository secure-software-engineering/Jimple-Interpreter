package de.upb.soot.jimple.interpreter.cli;

import de.upb.soot.jimple.interpreter.Configuration;
import de.upb.soot.jimple.interpreter.EntryPoint;

import org.kohsuke.args4j.Option;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class Options {

  private int entryLine = 1;
  private String entryMethod;

  private String classPath;

  public EntryPoint getEntryPoint() {
    return new EntryPoint(entryMethod, entryLine);
  }

  @Option(name = "EntryLine", aliases = "l", usage = "Sets the line to start interpreting the given Jimple source")
  public void setEntryLine(int entryLine) {
    this.entryLine = entryLine;
  }

  @Option(name = "EntryMethod", aliases = "m", required = true,
      usage = "Sets the method to start interpreting the given Jimple source. Pass method in Jimple's method signature syntax, e.g. <package.Main: void main(java.lang.String[])>")
  public void setEntryMethod(String entryMethod) {
    this.entryMethod = entryMethod;
  }

  public String getClassPath() {
    return classPath;
  }

  @Option(name = "ClassPath", aliases = "cp",
      usage = "Sets the class path on which required classes for execution will be searched", required = true)
  public void setClassPath(String classPath) {
    this.classPath = classPath;
  }

  public Configuration toConfig() {
    Configuration configuration = new Configuration(classPath);

    return configuration;
  }
}
