package com.store.electronicsStore.testBeans;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.Serializable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory implements Serializable {

  private static final long serialVersionUID = 4950947366205506334L;

  public WebDriverFactory() {

  }

  public WebDriver chromeDriver() {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver();
  }

  public WebDriver internetExplorerDriver() {
    WebDriverManager.edgedriver().setup();
    return new EdgeDriver();
  }

  public WebDriver fireFoxDriver() {
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver();
  }

  public WebDriver ieDriver() {
    WebDriverManager.iedriver().setup();
    return new InternetExplorerDriver();
  }

  public WebDriver chromiumDriver() {
    WebDriverManager.chromiumdriver().setup();
    return new ChromeDriver();
  }

  public WebDriver oprahDriver() {
    WebDriverManager.operadriver().setup();
    return new OperaDriver();
  }

}
