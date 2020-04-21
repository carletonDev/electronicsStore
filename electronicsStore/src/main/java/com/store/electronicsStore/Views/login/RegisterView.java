package com.store.electronicsStore.Views.login;

import com.store.context.StateEnum;
import com.store.electronicsStore.hibernate.pojos.Login;
import com.store.electronicsStore.hibernate.pojos.Roles;
import com.store.electronicsStore.hibernate.pojos.Users;
import com.store.electronicsStore.hibernate.repositories.LoginRepository;
import com.store.electronicsStore.hibernate.repositories.RolesRepository;
import com.store.electronicsStore.hibernate.repositories.UsersRepository;
import com.store.electronicsStore.security.RolesEnum;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

@Route(value = RegisterView.ROUTE)
@PageTitle("Register")
public class RegisterView extends VerticalLayout {

  public static final String ROUTE = "register";
  private final UsersRepository usersRepository;
  private final LoginRepository loginRepository;
  private final RolesRepository rolesRepository;
  private TextField firstName;
  private TextField lastName;
  private TextField address;
  private TextField city;
  private TextField username;
  private PasswordField password;
  private EmailField email;
  private ComboBox<StateEnum> state;
  private NumberField phone;
  private ComboBox<Roles> rolesComboBox;
  private Button register;
  //Save Objects
  private Users newUser = new Users();
  private Login newLogin = new Login();
 // private Binder<>

  @Autowired
  public RegisterView(UsersRepository usersRepository
      , LoginRepository loginRepository
      , RolesRepository rolesRepository) {
    this.usersRepository = usersRepository;
    this.loginRepository = loginRepository;
    this.rolesRepository = rolesRepository;
  }

  public TextField createTextField(String caption) {
    TextField textField = new TextField();
    textField.setLabel(caption);
    textField.setRequired(true);
    return textField;
  }

  public PasswordField createPasswordField(String caption) {
    PasswordField password = new PasswordField();

    return password;
  }

  public ComboBox<StateEnum> createStateComboBox() {
    ComboBox<StateEnum> state = new ComboBox<>();
    List<StateEnum> collection = new ArrayList<>();
    CollectionUtils.mergeArrayIntoCollection(StateEnum.values(), collection);
    ObservableList<StateEnum> list = FXCollections.observableList(collection);
    state.setEditable(false);
    state.setItems(list);
    return state;
  }

  public Button createRegisterButton(String caption) {
    Button button = new Button();
    button.setText(caption);
    button.addClickListener(buttonClickEvent -> registerUser());
    return button;
  }


  public ComboBox<Roles> createRolesComboBox() {
    ComboBox<Roles> rolesComboBox = new ComboBox<>();
    List<Roles> collection = new ArrayList<>();
    rolesRepository.findAll().forEach(roles -> {
      if (!roles.getRoleType().equals(RolesEnum.admin.name())) {
        collection.add(roles);
      }
    });
    ObservableList<Roles> list = FXCollections.observableList(collection);
    rolesComboBox.setItems(list);
    return rolesComboBox;
  }

  private void registerUser() {
    newUser.setAddress(!address.isEmpty() ? address.getValue() : address.getEmptyValue());
    newUser.setCity(!city.isEmpty() ? city.getValue() : city.getEmptyValue());
    newUser.setEmail(!email.isEmpty()?email.getValue():email.getEmptyValue());
  }


}
