package com.store.electronicsStore.pageobjectmodels;

import static com.store.electronicsStore.decorators.LoginPageDecorator.loginSuccessful;

import com.store.electronicsStore.decorators.LoginPageDecorator;
import com.store.electronicsStore.hibernate.pojos.Login;
import com.vaadin.flow.component.UI;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.Test;

public class LoginPageObject {

  @Getter
  private WebDriver driver;

  @FindBys({
      @FindBy()
  })
  private WebElement userTextField;
  private WebElement passwordTextField;
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


}
