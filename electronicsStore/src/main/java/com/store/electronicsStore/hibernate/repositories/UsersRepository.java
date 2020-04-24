package com.store.electronicsStore.hibernate.repositories;

import com.store.electronicsStore.hibernate.pojos.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
