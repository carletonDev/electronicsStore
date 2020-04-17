package com.store.hibernate.repositories;

import com.store.hibernate.pojos.Reciept;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecieptRepository extends CrudRepository<Reciept, Integer> {

}
