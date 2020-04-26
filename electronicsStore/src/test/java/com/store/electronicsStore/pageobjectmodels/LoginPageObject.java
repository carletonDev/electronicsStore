package com.store.electronicsStore.pageobjectmodels;

import static com.store.electronicsStore.decorators.LoginPageDecorator.loginSuccessful;

import com.store.electronicsStore.decorators.LoginPageDecorator;
import com.store.electronicsStore.hibernate.pojos.Login;
import com.vaadin.flow.component.UI;
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

  @Getter
  private WebDriver driver;

  @FindAll({
      @FindBy(id="vaadinLoginUsername"),
      @FindBy(name="username")
  })
  private WebElement userTextField;
  @FindAll({
      @FindBy(id="vaadinLoginPassword"),
      @FindBy(name="password")
  })
  private WebElement passwordTextField;
  @FindBys({
      @FindBy(id="button")
  })
  private WebElement submit;

  public LoginPageObject(WebDriver driver) {
    this.driver = driver;
  }

  @Test
  public void testLogin(Login login) {
    driver.get("https://localhost:8080/login");
    userTextField.sendKeys(login.getUsername());
    passwordTextField.sendKeys(login.getPassword());
    submit.click();
    loginSuccessful.accept(this);

  }
  //todo move to decorator class if too many Assert Tests
  private static Consumer<LoginPageObject> loginSuccessful=(page)->{
    Assert.assertEquals(page.getDriver().getCurrentUrl(),"https://localhost:8080/login");
  };



}
