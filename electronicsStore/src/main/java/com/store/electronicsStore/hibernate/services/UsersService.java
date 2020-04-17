package com.store.electronicsStore.hibernate.services;

import com.store.electronicsStore.hibernate.pojos.Users;
import com.store.electronicsStore.hibernate.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {


  private final UsersRepository repository;

  public UsersService(@Autowired UsersRepository repository){
    this.repository=repository;
  }

  public Iterable<Users> findAll() {
    return repository.findAll();
  }
  public Users findById(Integer id){
   return repository.findById(id).orElse(null);
  }
}
