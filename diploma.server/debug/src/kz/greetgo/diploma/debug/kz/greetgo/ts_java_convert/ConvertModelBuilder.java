package kz.greetgo.diploma.debug.kz.greetgo.ts_java_convert;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class ConvertModelBuilder {
  private File sourceDir = null;
  private File destinationDir = null;
  private String destinationPackage = null;
  private String scanSubDir;

  public ConvertModelBuilder sourceDir(File sourceDir, String scanSubDir) {
    Objects.requireNonNull(sourceDir);
    this.sourceDir = sourceDir;
    this.scanSubDir = scanSubDir;
    return this;
  }

  public ConvertModelBuilder sourceDir(Path sourceDir, String scanSubDir) {
    Objects.requireNonNull(sourceDir);
    this.sourceDir = sourceDir.toFile();
    this.scanSubDir = scanSubDir;
    return this;
  }

  public ConvertModelBuilder sourceDir(String sourceDirName, String scanSubDir) {
    Objects.requireNonNull(sourceDirName);
    this.sourceDir = new File(sourceDirName);
    this.scanSubDir = scanSubDir;
    return this;
  }


  public ConvertModelBuilder destinationDir(File destinationDir) {
    Objects.requireNonNull(destinationDir);
    this.destinationDir = destinationDir;
    return this;
  }

  public ConvertModelBuilder destinationDir(Path destinationDir) {
    Objects.requireNonNull(destinationDir);
    this.destinationDir = destinationDir.toFile();
    return this;
  }

  public ConvertModelBuilder destinationDir(String destinationDirName) {
    Objects.requireNonNull(destinationDirName);
    this.destinationDir = new File(destinationDirName);
    return this;
  }


  public ConvertModelBuilder destinationPackage(String destinationPackage) {
    this.destinationPackage = destinationPackage;
    return this;
  }

  public ConvertModelBuilder destinationPackage(Package destinationPackage) {
    this.destinationPackage = destinationPackage.getName();
    return this;
  }

  public ConvertModel create() {
    if (sourceDir == null) throw new RuntimeException("sourceDir == null: please, define it");
    if (destinationDir == null) throw new RuntimeException("destinationDir == null: please, define it");
    return new ConvertModel(sourceDir, scanSubDir, destinationDir, destinationPackage);
  }
}
