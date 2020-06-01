package com.store.restAssured;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Generic {
  private static PrintStream ps;
  private static String logFilePath;

  public static void logPrintStream(String testCaseName) throws FileNotFoundException {
    logFilePath = Generic.getCurrentDirectory()+"\\result" + File.separator + testCaseName + ".html";

    File file = new File(logFilePath);
    FileOutputStream fos = new FileOutputStream(file, true);
    ps = new PrintStream(fos);
  }

  public static PrintStream getPrintStream() {
    return ps;
  }

  static String getLogFilePath() {
    return logFilePath;
  }

  static String getCurrentDirectory() {
    Path root = Paths.get(".").normalize().toAbsolutePath();
    return root.toString();
  }
}
