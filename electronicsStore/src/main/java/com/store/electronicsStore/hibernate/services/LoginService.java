package com.store.electronicsStore.hibernate.services;

import com.store.electronicsStore.hibernate.pojos.Login;
import com.store.electronicsStore.hibernate.repositories.LoginRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements Serializable {

  private final LoginRepository loginRepository;
  private final Logger logger = LogManager.getLogger(LoginService.class);

  public LoginService(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }

  public Login findUser(String username, String password) {
    AtomicReference<Login> loggedInUser = new AtomicReference<>();
    loginRepository.findAll().iterator().forEachRemaining(login -> {
      if (Objects.equals(login.getUsername(), username)
          && Objects.equals(login.getPassword(), password)) {
        loggedInUser.set(login);
      }
    });
    return loggedInUser.get();
  }

  public Login findUser(String username) {
    logger.info(loginRepository);
    AtomicReference<Login> loggedInUser = new AtomicReference<>();
    loginRepository.findAll().iterator().forEachRemaining(login -> {
      if (Objects.equals(login.getUsername(), username)) {
        loggedInUser.set(login);
      }
    });
    return loggedInUser.get();
  }
  public List<Login> findAllLogins(){
    return loginRepository.findAll();
  }
  public  Object[][] createLoginObjects() {
    ArrayList<ArrayList<Object>> twoDArray = new ArrayList<>();

    for (Login user : loginRepository.findAll()) {
      twoDArray.add(new ArrayList<>(Collections.singletonList(user)));
    }
    return twoDArray.stream().map(ArrayList::toArray).toArray(Object[][]::new);
  }

  public Iterator<Login> findAll() {
    return loginRepository.findAll().iterator();
  }

}
