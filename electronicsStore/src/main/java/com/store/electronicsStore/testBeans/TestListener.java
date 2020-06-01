package com.store.electronicsStore.testBeans;

import static com.store.electronicsStore.restAssured.Reporting.endReporting;
import static com.store.electronicsStore.restAssured.Reporting.startReporting;
import static com.store.electronicsStore.restAssured.Reporting.startTestReporting;

import org.springframework.stereotype.Component;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Component
public class TestListener implements ITestListener {



  @Override
  public void onTestStart(ITestResult result) {
    startReporting();
    startTestReporting(result.getTestName());
  }

  @Override
  public void onTestSuccess(ITestResult result) {

  }

  @Override
  public void onTestFailure(ITestResult result) {

  }
  public void onFinish(ITestContext context){
    endReporting();
  }



}
