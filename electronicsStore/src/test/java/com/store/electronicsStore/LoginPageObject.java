package com.store.electronicsStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

  private WebDriver driver;

  private WebElement userTextField;
  private WebElement passwordTextField;

  public LoginPageObject(WebDriver driver) {
    this.driver = driver;
  }


}
