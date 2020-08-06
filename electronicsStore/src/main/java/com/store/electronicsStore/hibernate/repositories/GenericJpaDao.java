package com.store.electronicsStore.hibernate.repositories;

import com.store.electronicsStore.hibernate.services.AbstractJpaDao;
import java.io.Serializable;


public class GenericJpaDao<T extends Serializable>
    extends AbstractJpaDao<T> implements IGenericDao<T> {

  public GenericJpaDao(Class<T> entity) {
    super(entity);
  }
}

