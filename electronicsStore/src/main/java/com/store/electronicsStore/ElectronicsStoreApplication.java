package com.store.electronicsStore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAutoConfiguration
@Configuration
@ComponentScan
@EntityScan("com.store.electronicsStore.hibernate.pojos")
@EnableJpaRepositories("com.store.electronicsStore.hibernate.repositories")
@SpringBootApplication
public class ElectronicsStoreApplication {


  public static void main(String[] args) {
    SpringApplication.run(ElectronicsStoreApplication.class, args);
  }


}
