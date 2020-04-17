package com.store.hibernate.repositories;

import com.store.hibernate.pojos.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

}
