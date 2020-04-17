package com.store.hibernate.repositories;

import com.store.hibernate.pojos.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login,Integer> {

}
