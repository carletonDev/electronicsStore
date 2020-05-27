package com.store.electronicsStore.decorators;

import com.store.electronicsStore.pageobjectmodels.LoginPageObject;
import java.util.function.Consumer;
import org.testng.Assert;

public class LoginPageDecorator {

  public static Consumer<LoginPageObject> loginSuccessful=(page)->{
    Assert.assertEquals(page.getDriver().getCurrentUrl(),"https://localhost:8080/");
  };

}
