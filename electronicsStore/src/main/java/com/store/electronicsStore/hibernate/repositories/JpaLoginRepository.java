package com.store.electronicsStore.hibernate.repositories;

import com.store.electronicsStore.hibernate.pojos.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLoginRepository extends JpaRepository<Login,Integer> {

}
