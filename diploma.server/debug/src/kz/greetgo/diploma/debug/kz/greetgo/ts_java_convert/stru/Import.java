package kz.greetgo.diploma.debug.kz.greetgo.ts_java_convert.stru;


import java.util.Objects;
import kz.greetgo.diploma.debug.kz.greetgo.ts_java_convert.TsFileReference;

public class Import {
  public final String className;
  public final TsFileReference tsFileReference;
  public final int lineNo;

  public Import(String className, TsFileReference tsFileReference, int lineNo) {
    this.className = className;
    this.tsFileReference = tsFileReference;
    this.lineNo = lineNo;
  }

  public ClassStructure toClassStructure() {
    return Objects.requireNonNull(tsFileReference.classStructure);
  }
}
