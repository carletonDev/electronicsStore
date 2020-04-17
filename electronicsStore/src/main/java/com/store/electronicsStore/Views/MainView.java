package com.store.electronicsStore.Views;

import com.store.hibernate.pojos.Login;
import com.store.hibernate.services.LoginService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {

  private final LoginService loginService;
  private TextField username = createTextfield("UserName");
  private TextField password = createTextfield("Password");
  private Button submit = createButton("Login");


  public MainView(@Autowired LoginService loginService) {
    this.loginService = loginService;
    submit.addClickListener(this::checkLogin);
    this.add(formLayout(username)
        , formLayout(password)
        , submit);
  }

  private void checkLogin(ClickEvent<Button> buttonClickEvent) {
   Login user=loginService.findUser(username.getValue(),password.getValue());
    Notification notification = new Notification();
    notification.setPosition(Position.BOTTOM_END);


    if(user !=null){
      notification.setText("Login Successful! welcome "+user.getUsers().getFirstName()+" "
      +user.getUsers().getLastName());
      notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
      notification.open();
    }else{
      notification.setText("Login Failed!");
      notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
      notification.open();
    }
  }

  private FormLayout formLayout(Component... components) {
    FormLayout formLayout = new FormLayout();
    formLayout.add(components);
    return formLayout;
  }

  private TextField createTextfield(String caption) {
    TextField textField = new TextField();
    textField.setLabel(caption);
    return textField;
  }

  private Button createButton(String caption) {
    Button button = new Button();
    button.setText(caption);
    return button;
  }
}
