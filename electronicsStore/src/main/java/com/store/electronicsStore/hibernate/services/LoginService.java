package com.store.electronicsStore.hibernate.services;

import com.store.electronicsStore.hibernate.pojos.Login;
import com.store.electronicsStore.hibernate.repositories.LoginRepository;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements Serializable {

  private final LoginRepository loginRepository;


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
    AtomicReference<Login> loggedInUser = new AtomicReference<>();
    loginRepository.findAll().iterator().forEachRemaining(login -> {
      if (Objects.equals(login.getUsername(), username)) {
        loggedInUser.set(login);
      }
    });
    return loggedInUser.get();
  }

  public Iterator<Login> findAll() {
    return loginRepository.findAll().iterator();
  }

}
