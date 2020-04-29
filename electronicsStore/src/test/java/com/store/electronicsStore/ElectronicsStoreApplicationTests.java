package com.store.electronicsStore;


import com.store.electronicsStore.pageobjectmodels.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


@SpringBootTest(classes = ElectronicsStoreApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ElectronicsStoreApplicationTests extends AbstractTestNGSpringContextTests {


  @LocalServerPort
  private int serverPort = 8080;
  private WebDriverFactory drivers = new WebDriverFactory();
  private WebDriver driver;

  public ElectronicsStoreApplicationTests() {

  }

  private String getRootUrl() {
    return "http://localhost:" + serverPort;
  }

  @BeforeTest
  public void setupDriver() {
    driver = drivers.chromeDriver();
  }

  @Test
  void contextLoads() {
    LoginPageObject loginPageObject =
        PageFactory.initElements(driver, LoginPageObject.class);
    loginPageObject.testLogin("cabarrus", "nc23112");
  }

  @AfterTest
  public void cleanUp() {
    driver.close();
  }

}
