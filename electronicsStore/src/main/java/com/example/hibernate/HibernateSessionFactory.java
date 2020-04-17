package com.example.hibernate;

import com.example.hibernate.pojos.Item;
import com.example.hibernate.pojos.ItemSale;
import com.example.hibernate.pojos.Reciept;
import com.example.hibernate.pojos.Roles;
import com.example.hibernate.pojos.Users;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

  @Getter
  private final SessionFactory sessionFactory;

  private Logger logger = LogManager.getLogger(HibernateSessionFactory.class);

  public HibernateSessionFactory() {
    sessionFactory = buildSessionFactory();
  }

  private SessionFactory buildSessionFactory() {
    try {

      Configuration configuration = new Configuration();
      configuration.addAnnotatedClass(Roles.class);
      configuration.addAnnotatedClass(Users.class);
      configuration.addAnnotatedClass(Item.class);
      configuration.addAnnotatedClass(Reciept.class);
      configuration.addAnnotatedClass(ItemSale.class);

      return configuration.buildSessionFactory();

    } catch (Throwable ex) {
      logger.info("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }
}
