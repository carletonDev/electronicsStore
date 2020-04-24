package com.store.electronicsStore.hibernate.repositories;

import com.store.electronicsStore.hibernate.pojos.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
