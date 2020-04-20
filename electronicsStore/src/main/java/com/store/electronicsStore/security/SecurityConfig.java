package com.store.electronicsStore.security;


import com.store.electronicsStore.Views.login.LoginView;
import com.store.electronicsStore.hibernate.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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

  @Autowired
  private StoreUserDetailsService detailsService;
  @Autowired
  private RolesService rolesService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .requestCache().requestCache(new CustomRequestCache())
        .and().authorizeRequests()
        .requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/"+ LoginView.ROUTE).permitAll()
        //todo add logout successful url
        .and().logout();
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

}
