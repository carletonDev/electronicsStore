package com.store.electronicsStore;

import com.store.hibernate.services.UsersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan
@EntityScan("com.store.hibernate.pojos")
@EnableJpaRepositories("com.store.hibernate.repositories")
public class ElectronicsStoreApplication {

  private static Logger logger = LogManager.getLogger(ElectronicsStoreApplication.class);
  private static UsersService service = new UsersService();
  public static void main(String[] args) {
    logger.info(service.findAll().iterator().next());
    SpringApplication.run(ElectronicsStoreApplication.class, args);
  }


}
