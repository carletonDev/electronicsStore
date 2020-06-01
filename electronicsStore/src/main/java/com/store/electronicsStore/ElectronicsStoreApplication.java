package com.store.electronicsStore;

import com.store.electronicsStore.testBeans.TestListener;
import com.store.electronicsStore.testBeans.WebDriverFactory;
import com.store.electronicsStore.testBeans.WebDriverListener;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEncryptableProperties
@EntityScan("com.store.electronicsStore.hibernate.pojos")
@ComponentScan(basePackageClasses = {
    TestListener.class, WebDriverFactory.class, WebDriverListener.class
})
@EnableJpaRepositories("com.store.electronicsStore.hibernate.repositories")
@SpringBootApplication
public class ElectronicsStoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElectronicsStoreApplication.class, args);

  }


}
