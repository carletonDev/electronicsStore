package com.store.hibernate.repositories;

import com.store.hibernate.pojos.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<Roles,Integer> {

}
