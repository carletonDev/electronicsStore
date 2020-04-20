package com.store.electronicsStore.Views.login;


import com.store.electronicsStore.security.CustomRequestCache;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

@Tag("sa-login-view")
@Route(value = LoginView.ROUTE)
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
  public static final String ROUTE = "login";

  private LoginOverlay login = new LoginOverlay();

  @Autowired
  public LoginView(AuthenticationManager authenticationManager,
      CustomRequestCache requestCache){
    login.setAction("login");
    login.setOpened(true);
    login.setTitle("Electronics Store");
    login.setForgotPasswordButtonVisible(true);
    login.setDescription("Electronics Store Login");
    getElement().appendChild(login.getElement()); //
    add(login);
    login.addLoginListener(e -> { //
      try {
        // try to authenticate with given credentials, should always return not null or throw an {@link AuthenticationException}
        final Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(e.getUsername(), e.getPassword())); //

        // if authentication was successful we will update the security context and redirect to the page requested first
        SecurityContextHolder.getContext().setAuthentication(authentication); //
        login.close(); //
        UI.getCurrent().navigate(requestCache.resolveRedirectUrl()); //

      } catch (AuthenticationException ex) { //
        login.setError(true);
      }
    });
  }
  @Override
  public void beforeEnter(BeforeEnterEvent event) { //
    // inform the user about an authentication error
    if(!event.getLocation().getQueryParameters().getParameters().getOrDefault("error", Collections.emptyList()).isEmpty()) {
      login.setError(true); //
    }
  }

}
