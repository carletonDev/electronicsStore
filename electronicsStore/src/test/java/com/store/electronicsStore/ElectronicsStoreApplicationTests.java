package com.store.electronicsStore;


import com.store.electronicsStore.hibernate.repositories.LoginRepository;
import com.store.electronicsStore.pageobjectmodels.LoginPageObject;
import com.store.electronicsStore.testBeans.TestListener;
import com.store.electronicsStore.testBeans.WebDriverFactory;
import javax.validation.constraints.Max.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@SpringBootTest(classes = ElectronicsStoreApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ElectronicsStoreApplicationTests extends AbstractTestNGSpringContextTests {

  @Autowired
  private WebDriverFactory drivers;
  @Autowired
  private WebDriverEventListener listener;

  EventFiringWebDriver eventWebDriver;

  @Autowired
  private LoginRepository loginRepository;

  @BeforeTest
  public void setupDriver() {
    eventWebDriver=new EventFiringWebDriver(drivers.chromeDriver());
    eventWebDriver.register(listener);
  }

  @Test
  void loginToApplication() {

    LoginPageObject loginPageObject =
        PageFactory.initElements(eventWebDriver, LoginPageObject.class);
    loginRepository.findAll().stream().findFirst().ifPresent(userOneLogin -> loginPageObject
        .testLogin(userOneLogin.getUsername(), userOneLogin.getPassword()));

  }


}
