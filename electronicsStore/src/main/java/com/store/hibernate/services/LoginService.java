package com.store.hibernate.services;

import com.store.hibernate.pojos.Login;
import com.store.hibernate.repositories.LoginRepository;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private final LoginRepository loginRepository;


  public LoginService(@Autowired LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }
  public Login findUser(String username,String password){
    AtomicReference<Login> loggedInUser=new AtomicReference<>();
    loginRepository.findAll().iterator().forEachRemaining(login -> {
        if(Objects.equals(login.getUsername(),username)
            && Objects.equals(login.getPassword(),password)){
            loggedInUser.set(login);
        }
    });
    return loggedInUser.get();
  }

}
