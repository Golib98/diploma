package kz.greetgo.diploma.debug.kz.greetgo.ts_java_convert.errors;

public class ClassCannotBeMultipleArray extends ParseError {
  public ClassCannotBeMultipleArray(String place) {
    super("Field with type of a class cannot be multiple array at " + place);
  }
}
