package com.store.electronicsStore.hibernate.repositories;

import com.store.electronicsStore.hibernate.pojos.Roles;
import com.store.electronicsStore.hibernate.pojos.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

  @Query(value="SELECT user FROM Users user WHERE user.role=?1")
  List<Users> getAllUsersByRole(Roles role);
}
