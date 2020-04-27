package com.store.electronicsStore;


import com.store.electronicsStore.hibernate.pojos.Login;
import com.store.electronicsStore.pageobjectmodels.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


@SpringBootTest(classes = ElectronicsStoreApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ElectronicsStoreApplicationTests extends AbstractTestNGSpringContextTests {


  @LocalServerPort
  private int serverPort;
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

  @Test(dataProvider = "logins", dataProviderClass = DataProviderFactory.class)
  void contextLoads(Login login) {
    LoginPageObject loginPageObject = new LoginPageObject(driver);
    loginPageObject.testLogin(login);
  }

  @AfterTest
  public void cleanUp() {
    driver.close();
  }

}
