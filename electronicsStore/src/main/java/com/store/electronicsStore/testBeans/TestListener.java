package com.store.electronicsStore.testBeans;

import static com.store.restAssured.Reporting.startReporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Component;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Component
public class TestListener implements ITestListener {

  private ExtentHtmlReporter htmlReport;
  private ExtentReports report;

  public static String getCurrentDirectory() {
    Path root = Paths.get(".").normalize().toAbsolutePath();
    return root.toString();
  }

  @Override
  public void onTestStart(ITestResult result) {
    startReporting();
  }

  @Override
  public void onTestSuccess(ITestResult result) {

  }

  @Override
  public void onTestFailure(ITestResult result) {

  }



}
