package com.store.electronicsStore;


import com.store.electronicsStore.hibernate.repositories.LoginRepository;
import com.store.electronicsStore.hibernate.services.GuiceModules;
import com.store.electronicsStore.pageobjectmodels.LoginPageObject;
import javax.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@SpringBootTest(classes = ElectronicsStoreApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ElectronicsStoreApplicationTests extends AbstractTestNGSpringContextTests {

  @LocalServerPort
  private int serverPort = 8080;
  private WebDriverFactory drivers = new WebDriverFactory();
  private WebDriver driver;
  @Autowired
  private LoginRepository loginRepository;

  public ElectronicsStoreApplicationTests() {

  }

  private String getRootUrl() {
    return "http://localhost:" + serverPort+"/";
  }

  @BeforeTest
  public void setupDriver() {
    driver = drivers.chromeDriver();
  }

  @Test
  void contextLoads() {

    LoginPageObject loginPageObject =
        PageFactory.initElements(driver, LoginPageObject.class);
    loginRepository.findAll().stream().findFirst().ifPresent(userOneLogin -> loginPageObject
        .testLogin(userOneLogin.getUsername(), userOneLogin.getPassword()));

  }


}
