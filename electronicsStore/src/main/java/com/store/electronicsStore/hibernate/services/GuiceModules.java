package com.store.electronicsStore.hibernate.services;

import com.google.inject.AbstractModule;
import com.store.electronicsStore.hibernate.repositories.LoginRepository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GuiceModules extends AbstractModule {


  @Override
  protected void configure() {
    bind(LoginService.class).toInstance(beanFactory().getBean(LoginService.class));
    bind(LoginRepository.class).toInstance(beanFactory().getBean(LoginRepository.class));
  }

  private ListableBeanFactory beanFactory() {
    ListableBeanFactory beanFactory = new AnnotationConfigApplicationContext(LoginService.class
    );
    return beanFactory;
  }
}
