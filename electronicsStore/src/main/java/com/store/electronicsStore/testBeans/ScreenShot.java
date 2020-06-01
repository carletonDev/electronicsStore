package com.store.electronicsStore.testBeans;

import com.store.restAssured.Reporting;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

  public static void takeScreenshot(WebDriver driver) {
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    writeToImagesFolder(screenshot.getScreenshotAs(OutputType.FILE));
  }

  private static void writeToImagesFolder(File screenshot){
   try{
     FileUtils.copyFile(screenshot, new File("/src/main/java/TestImages/" + LocalDateTime.now()));
   }
    catch (IOException ex){
      Reporting.getTestCaseReference().info("Error writing to file...");
    }
  }

}
