package com.store.electronicsStore;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEncryptableProperties
@EntityScan("com.store.electronicsStore.hibernate.pojos")
@EnableAutoConfiguration(exclude = MongoAutoConfiguration.class)
@EnableJpaRepositories("com.store.electronicsStore.hibernate.repositories")
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class ElectronicsStoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElectronicsStoreApplication.class, args);

  }


}
