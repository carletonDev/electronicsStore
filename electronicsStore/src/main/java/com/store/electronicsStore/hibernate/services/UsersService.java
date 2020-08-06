package com.store.electronicsStore.hibernate.services;

import com.store.electronicsStore.hibernate.pojos.Users;
import com.store.electronicsStore.hibernate.repositories.LoginRepository;
import com.store.electronicsStore.hibernate.repositories.UsersRepository;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UsersService {


  private final UsersRepository repository;
  private final LoginRepository loginRepository;
  private Logger logger = LogManager.getLogger(UsersService.class);

  public UsersService(UsersRepository repository, LoginRepository loginRepository) {
    this.repository = repository;
    this.loginRepository = loginRepository;
  }

  public Iterable<Users> findAll() {
    return repository.findAll();
  }

  public Users findById(Integer id) {
    return repository.findById(id).orElse(null);
  }

  public Users getLoggedInUsers(Object principal) {
    Users user = null;
    if (principal instanceof UserDetails) {
      UserDetails details = ((UserDetails) principal);
      logger.info(details);
      logger.info( details.getUsername());
      loginRepository.findbyUsername(details.getUsername());
    }
      return user;

    }
}
