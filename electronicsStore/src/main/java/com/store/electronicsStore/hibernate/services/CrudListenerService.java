package com.store.electronicsStore.hibernate.services;

import com.store.electronicsStore.hibernate.repositories.GenericJpaDao;
import com.store.electronicsStore.hibernate.repositories.TimeSheetRepository;
import com.store.electronicsStore.security.AuthenticationFacade;
import java.io.Serializable;
import java.util.Collection;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

@Service
public class CrudListenerService {

  private final AuthenticationFacade facade;
  private final UsersService service;
  private final TimeSheetRepository timeSheetRepository;

  public CrudListenerService(AuthenticationFacade facade, UsersService service,
      TimeSheetRepository timeSheetRepository) {
    this.facade = facade;
    this.service = service;
    this.timeSheetRepository = timeSheetRepository;

  }

  <T extends Serializable> CrudListener<T> setCrudListener(Class<T> entity) {
    GenericJpaDao<T> dao = new GenericJpaDao<>(entity);
    return new CrudListener<T>() {

      @Override
      public Collection<T> findAll() {
        if (!entity.getName().contains("TimeSheet")) {
          return dao.findAll();
        } else {
          return (Collection<T>) timeSheetRepository.findTimesheetsByUser(
              service.getLoggedInUsers(facade.getAuthentication().getPrincipal()));
        }
      }

      @Override
      public T add(T t) {
        dao.save(t);
        return t;
      }

      @Override
      public T update(T t) {
        dao.update(t);
        return t;
      }

      @Override
      public void delete(T t) {
        dao.delete(t);

      }
    };
  }
}
