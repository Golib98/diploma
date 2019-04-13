package kz.greetgo.diploma.debug.launchers;

import java.io.File;
import kz.greetgo.diploma.controller.util.Modules;
import kz.greetgo.diploma.debug.kz.greetgo.ts_java_convert.ConvertModelBuilder;

public class LaunchModelConverter {
  public static void main(String[] args) throws Exception {
    File sourceDir = Modules.clientDir().toPath().resolve("src").toFile();
    File destinationDir = Modules.controllerDir().toPath().resolve("src").toFile();
    String destinationPackage = "kz.greetgo.diploma.controller.model";

    new ConvertModelBuilder()
      .sourceDir(sourceDir, "model/gen")
      .destinationDir(destinationDir)
      .destinationPackage(destinationPackage)
      .create().execute();
  }
}
