package kz.greetgo.diploma.debug.kz.greetgo.ts_java_convert.errors;

public class CannotFindClassInImports extends ParseError {
  public CannotFindClassInImports(String className, String place) {
    super("Cannot find class [[" + className + "]] in " + place);
  }
}
