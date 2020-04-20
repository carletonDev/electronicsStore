package com.store.electronicsStore.Views;

import com.store.electronicsStore.hibernate.pojos.Login;
import com.store.electronicsStore.hibernate.services.LoginService;
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

@Route(value = "main")
public class MainView extends VerticalLayout {




  public MainView() {

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
