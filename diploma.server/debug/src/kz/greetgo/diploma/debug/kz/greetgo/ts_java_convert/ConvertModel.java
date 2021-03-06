package kz.greetgo.diploma.debug.kz.greetgo.ts_java_convert;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kz.greetgo.diploma.debug.kz.greetgo.ts_java_convert.stru.ClassAttr;
import kz.greetgo.diploma.debug.kz.greetgo.ts_java_convert.stru.ClassStructure;
import kz.greetgo.diploma.debug.kz.greetgo.ts_java_convert.stru.EnumElement;


public class ConvertModel {
  private final File sourceDir;
  private final File scanDir;
  private final File destinationDir;
  private final String destinationPackage;

  ConvertModel(File sourceDir, String scanSubDir, File destinationDir, String destinationPackage) {
    this.sourceDir = sourceDir;
    this.scanDir = resolve(sourceDir, scanSubDir);
    this.destinationDir = destinationDir;
    this.destinationPackage = destinationPackage;
  }

  private static File resolve(File sourceDir, String subDir) {
    if (subDir == null) return sourceDir;
    return sourceDir.toPath().resolve(subDir).toFile();
  }

  public void execute() throws Exception {
    List<TsFileReference> files = TsFileReference.scanForTs(scanDir);

    defineStructure(files);

    for (TsFileReference file : files) {
      System.out.println(file);
      for (ClassAttr classAttr : file.attrList) {
        System.out.println("    " + classAttr);
      }

      generate(file.classStructure, destinationDir);
    }
  }

  void defineStructure(List<TsFileReference> files) throws Exception {
    for (TsFileReference file : files) {
      file.anotherFiles = ConvertModelUtil.deleteIt(file, files);
      file.sourceDir = sourceDir;
    }

    files.forEach(a -> a.defineRealPackage(destinationPackage));

    for (TsFileReference file : files) {
      file.fillAttributes();
    }
  }

  File generate(ClassStructure classStructure, File destinationDir) throws Exception {
    Imports imports = new Imports(classStructure);
    StringBuilder body = new StringBuilder();

    generateBody(classStructure, imports, body);

    File javaFile = classStructure.javaFile(destinationDir);
    javaFile.getParentFile().mkdirs();

    List<String> leaveFurther = readLeaveFurther(javaFile);
    if (leaveFurther.isEmpty()) {
      leaveFurther.add("}");
    }
    leaveFurther.add(0, "  //The following code would be not removed after regenerating");
    leaveFurther.add(1, "  ///LEAVE_FURTHER");

    try (PrintStream pr = new PrintStream(javaFile, "UTF-8")) {
      if (classStructure.hasPackage()) pr.println("package " + classStructure.aPackage + ";");
      pr.println();
      pr.println(imports.asStr());
      pr.println();
      pr.println(body);
      for (String line : leaveFurther) {
        pr.println(line);
      }
    }

    return javaFile;
  }

  static List<String> readLeaveFurther(File javaFile) {
    if (!javaFile.exists()) return new ArrayList<>();
    try {
      return readLeaveFurther(Files.readAllLines(javaFile.toPath(), StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static final Pattern LEAVE_FURTHER = Pattern.compile("\\s*///\\s*LEAVE_FURTHER\\s*");

  static List<String> readLeaveFurther(List<String> javaFileLines) {
    List<String> ret = new ArrayList<>();
    boolean adding = false;

    for (String line : javaFileLines) {
      if (!adding) {
        if (LEAVE_FURTHER.matcher(line).matches()) {
          adding = true;
          continue;
        }
        continue;
      }

      ret.add(line);
    }

    return ret;
  }

  private void generateBody(ClassStructure classStructure, Imports imports, StringBuilder body) {
    appendComment(body, classStructure.classComment);
    String mimeType = classStructure.isEnum() ? "enum" : "class";
    body.append("public ").append(mimeType).append(" ").append(classStructure.name).append(" {\n");

    for (EnumElement enumElement : classStructure.enumElementList) {
      appendComment(body, enumElement.comment);
      body.append("  ").append(enumElement.value).append(",\n");
    }
    if (!classStructure.enumElementList.isEmpty()) {
      body.append("  ;\n");
    }

    for (ClassAttr attr : classStructure.attrList) {
      appendComment(body, attr.comment);
      body.append("  public ");
      body.append(imports.typeStr(attr.type, attr.isArray)).append(' ').append(attr.name);
      if (attr.isArray) {
        body.append(" = new ");
        body.append(imports.name(ArrayList.class.getName()));
        body.append("<>()");
      }
      body.append(";\n");
    }

//    body.append("}");
  }

  private static void appendComment(StringBuilder dest, List<String> comment) {
    if (comment == null) return;
    for (String line : comment) {
      dest.append(line).append('\n');
    }
  }
}
