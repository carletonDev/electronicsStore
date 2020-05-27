package com.store.electronicsStore.pageobjectmodels;

import com.store.electronicsStore.hibernate.pojos.Login;
import java.util.function.Consumer;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageObject {

  //todo move to decorator class if too many Assert Tests
  private static Consumer<LoginPageObject> loginSuccessful = (page) -> {
    Assert.assertEquals(page.getDriver().getCurrentUrl(), "http://localhost:8080");
  };
  //
  @Getter
  private WebDriver driver;
  @FindBy(css = "#vaadinLoginUsername > input")
  private WebElement userTextField;
  @FindBy(css="#vaadinLoginPassword > input")
  private WebElement passwordTextField;
  @FindBy(css="vaadin-button")
  private WebElement submit;

  public LoginPageObject(WebDriver driver) {
    this.driver = driver;

  }

  @Test
  public void testLogin(String username, String password) {
    driver.get("http://localhost:8080/login");
    userTextField.sendKeys(username);
    passwordTextField.sendKeys(password);
    submit.click();
    loginSuccessful.accept(this);

  }


}
