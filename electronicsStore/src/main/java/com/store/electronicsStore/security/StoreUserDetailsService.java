package com.store.electronicsStore.security;

import com.store.electronicsStore.hibernate.pojos.Login;
import com.store.electronicsStore.hibernate.services.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StoreUserDetailsService implements UserDetailsService {


  private LoginService loginService;
  private Logger logger = LogManager.getLogger(StoreUserDetailsService.class);

  public StoreUserDetailsService(LoginService loginService) {
    this.loginService = loginService;
  }

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    logger.info(loginService);
    Login loggedInUser = loginService.findUser(userName);

    if (loggedInUser == null) {
      throw new UsernameNotFoundException("UserName " + userName + " Not Found!");
    }
    return toUserDetails(loggedInUser);
  }

  private UserDetails toUserDetails(Login loggedInUser) {

    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    return User.withUsername(loggedInUser.getUsername())
        .password(encoder.encode(loggedInUser.getPassword()))
        .roles(loggedInUser.getUsers().getRole().getRoleType()).build();
  }
}
