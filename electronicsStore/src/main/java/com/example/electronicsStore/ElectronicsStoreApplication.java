package com.example.electronicsStore;

import com.example.hibernate.HibernateSessionFactory;
import com.example.hibernate.pojos.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElectronicsStoreApplication {

  private static Logger logger = LogManager.getLogger(ElectronicsStoreApplication.class);
  private static HibernateSessionFactory hibernate = new HibernateSessionFactory();
  private static SessionFactory sessionFactory = hibernate.getSessionFactory();
  public static void main(String[] args) {

    logger.info(sessionFactory.getCurrentSession().byId(Users.class).load(1));
    SpringApplication.run(ElectronicsStoreApplication.class, args);
  }


}
