package com.store.electronicsStore;


import com.store.electronicsStore.dataproviderfactories.DataProviderFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ElectronicsStoreApplicationTests {

  @LocalServerPort
  private int serverPort;

  private WebDriver driver;

  @BeforeTest
  public void setupDriver(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

  }

  @Test(dataProvider = "logins", dataProviderClass = DataProviderFactory.class)
  void contextLoads() {

  }

}
