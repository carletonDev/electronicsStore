package com.store.electronicsStore;

import com.store.electronicsStore.hibernate.pojos.Login;
import com.store.electronicsStore.hibernate.repositories.LoginRepository;
import java.util.ArrayList;
import java.util.Collections;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

  private LoginRepository loginRepository;


  public DataProviderFactory(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }

  @DataProvider(name = "logins")
  public Object[][] logins() {
    return createLoginObjects();
  }

  private Object[][] createLoginObjects() {
    ArrayList<ArrayList<Object>> twoDArray = new ArrayList<>();

    for (Login user : loginRepository.findAll()) {
      twoDArray.add(new ArrayList<>(Collections.singletonList(user)));
    }
    return twoDArray.stream().map(ArrayList::toArray).toArray(Object[][]::new);
  }


}
