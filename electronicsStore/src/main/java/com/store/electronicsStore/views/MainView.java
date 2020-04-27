package com.store.electronicsStore.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "main", layout = MainLayout.class)
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
