package com.store.electronicsStore.Views.login;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = RegisterView.ROUTE)
@PageTitle("Register")
public class RegisterView extends VerticalLayout {
  public static final String ROUTE="register";

  public RegisterView(){
    add(new Label("check nav to register"));
  }

}
