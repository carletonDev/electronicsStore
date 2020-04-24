package com.store.electronicsStore.hibernate.repositories;

import com.store.electronicsStore.hibernate.pojos.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSaleRepository extends JpaRepository<Sale, Integer> {

}
