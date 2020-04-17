package com.store.hibernate.repositories;

import com.store.hibernate.pojos.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSaleRepository extends CrudRepository<Sale, Integer> {

}
