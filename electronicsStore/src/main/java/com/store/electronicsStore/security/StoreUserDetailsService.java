package com.store.electronicsStore.security;

import com.store.electronicsStore.hibernate.pojos.Login;
import com.store.electronicsStore.hibernate.services.LoginService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StoreUserDetailsService implements UserDetailsService {

  @Autowired
  private LoginService loginService;
  private ArrayList<Login> userDetails = new ArrayList<>();

  public StoreUserDetailsService() {

  }

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    Login loggedInUser = loginService.findUser(userName);

    if (loggedInUser == null) {
      throw new UsernameNotFoundException("UserName " + userName + " Not Found!");
    }
    return toUserDetails(loggedInUser);
  }

  private UserDetails toUserDetails(Login loggedInUser) {
    return User.withUsername(loggedInUser.getUsername())
        .password(loggedInUser.getPassword())
        .roles(loggedInUser.getUsers().getRole().getRoleType()).build();
  }
}
