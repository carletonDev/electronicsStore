package com.store.electronicsStore;

import com.store.electronicsStore.hibernate.pojos.Login;
import com.store.electronicsStore.hibernate.repositories.LoginRepository;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

  private LoginRepository loginRepository;

  @Autowired
  public DataProviderFactory(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }

  @DataProvider(name = "login")
  public Object[][] logins() {
    return createLoginObjects(loginRepository);
  }

  private Object[][] createLoginObjects(
      LoginRepository loginRepository) {
    ArrayList<ArrayList<Object>> twoDArray = new ArrayList<>();

    for (Login user : loginRepository.findAll()) {
      twoDArray.add(new ArrayList<>(Collections.singletonList(user)));
    }
    return twoDArray.stream().map(ArrayList::toArray).toArray(Object[][]::new);
  }


}
