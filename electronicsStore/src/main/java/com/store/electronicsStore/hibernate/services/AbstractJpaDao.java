package com.store.electronicsStore.hibernate.services;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDao<T extends Serializable> {

  @PersistenceContext
  EntityManager entityManager;
  private Class<T> entity;

  public AbstractJpaDao(Class<T> clazz) {
    this.entity = entity;
  }


  public T findOne(Long id) {
    return entityManager.find(entity, id);
  }

  public List<T> findAll() {
    return (List<T>) entityManager.createQuery("from " + entity.getName())
        .getResultList();
  }

  public void save(T entity) {
    entityManager.persist(entity);
  }

  public void update(T entity) {
    entityManager.merge(entity);
  }

  public void delete(T entity) {
    entityManager.remove(entity);
  }

  public void deleteById(Long entityId) {
    T entity = findOne(entityId);
    delete(entity);
  }
}
