package com.store.electronicsStore.security;

import com.store.electronicsStore.Views.login.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private static final String LOGIN_URL = "/" + LoginView.ROUTE;

  @Autowired
  private StoreUserDetailsService detailsService;


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .requestCache().requestCache(new CustomRequestCache())
        .and().authorizeRequests()
        .requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()
        .anyRequest().authenticated()
        .and().formLogin().loginPage(LOGIN_URL).permitAll()
        .loginProcessingUrl(LOGIN_URL)
        .failureUrl(LOGIN_URL)
        .and().logout().logoutSuccessUrl(LOGIN_URL);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers(
        // Vaadin Flow static resources //
        "/VAADIN/**",

        // the standard favicon URI
        "/favicon.ico",

        // the robots exclusion standard
        "/robots.txt",

        // web application manifest //
        "/manifest.webmanifest",
        "/sw.js",
        "/offline-page.html",

        // (development mode) static resources //
        "/frontend/**",

        // (development mode) webjars //
        "/webjars/**",

        // (production mode) static resources //
        "/frontend-es5/**", "/frontend-es6/**");
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception { //
    return super.authenticationManagerBean();
  }

  @Bean
  public CustomRequestCache requestCache() { //
    return new CustomRequestCache();
  }

  @Override
  public void configure(AuthenticationManagerBuilder builder)
      throws Exception {
    builder.userDetailsService(detailsService);
  }


}
