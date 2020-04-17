package com.store.hibernate.services;

import com.store.hibernate.pojos.Users;
import com.store.hibernate.repositories.UsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  @Autowired
  private UsersRepository repository;

  public Iterable<Users> findAll() {
    return repository.findAll();
  }
}
