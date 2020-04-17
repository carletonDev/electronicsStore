package com.store.hibernate.repositories;

import com.store.hibernate.pojos.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

}
