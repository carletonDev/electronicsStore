package com.store.electronicsStore.Views.login;

import com.store.context.StateEnum;
import com.store.electronicsStore.hibernate.pojos.Login;
import com.store.electronicsStore.hibernate.pojos.Roles;
import com.store.electronicsStore.hibernate.pojos.Users;
import com.store.electronicsStore.hibernate.repositories.LoginRepository;
import com.store.electronicsStore.hibernate.repositories.RolesRepository;
import com.store.electronicsStore.hibernate.repositories.UsersRepository;
import com.store.electronicsStore.security.RolesEnum;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

@Route(value = RegisterView.ROUTE)
@PageTitle("Register")
public class RegisterView extends VerticalLayout {

  public static final String ROUTE = "register";
  private final UsersRepository usersRepository;
  private final LoginRepository loginRepository;
  private final RolesRepository rolesRepository;
  private TextField firstName = createTextField("txt_first");
  private TextField lastName = createTextField("txt_last");
  private TextField address = createTextField("txt_address");
  private TextField city = createTextField("txt_city");
  private TextField username = createTextField("txt_username");
  private PasswordField password = createPasswordField();
  private EmailField email = createEmailField();
  private ComboBox<StateEnum> state = createStateComboBox();
  @SuppressWarnings("FieldCanBeLocal")
  private NumberField zip = createNumber("txt_zip", 5);
  private NumberField phone = createNumber("txt_phone", 10);
  //Save Objects
  private Users newUser = new Users();
  private Login newLogin = new Login();
  private Binder<RegisterBean> binder = new Binder<>(RegisterBean.class);
  @SuppressWarnings("FieldCanBeLocal")
  private Button register = createRegisterButton();

  @Autowired
  public RegisterView(UsersRepository usersRepository
      , LoginRepository loginRepository
      , RolesRepository rolesRepository) {
    this.usersRepository = usersRepository;
    this.loginRepository = loginRepository;
    this.rolesRepository = rolesRepository;

    bind();
    add(horizontalLayout(formLayout(firstName), formLayout(lastName))
        , horizontalLayout(formLayout(address), formLayout(city), formLayout(state), formLayout(zip))
        , formLayout(email)
        , formLayout(username)
        , formLayout(password)
        , formLayout(phone)
        , register);
  }

  private TextField createTextField(String caption) {
    TextField textField = new TextField();
    textField.setLabel(caption);
    textField.setRequired(true);
    textField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
    return textField;
  }

  private EmailField createEmailField() {
    EmailField email = new EmailField();
    email.setLabel("txt_email");
    email.setMaxLength(50);
    email.addThemeVariants(TextFieldVariant.LUMO_SMALL);
    return email;
  }

  private NumberField createNumber(String caption, Integer max) {
    NumberField numberField = new NumberField();
    numberField.setLabel(caption);
    numberField.setMax(max);
    numberField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
    return numberField;
  }

  private PasswordField createPasswordField() {
    PasswordField password = new PasswordField();
    password.setLabel("txt_pass");
    password.setMaxLength(10);
    password.setRevealButtonVisible(true);
    password.addThemeVariants(TextFieldVariant.LUMO_SMALL);

    return password;
  }

  private ComboBox<StateEnum> createStateComboBox() {
    ComboBox<StateEnum> state = new ComboBox<>();

    List<StateEnum> collection = new ArrayList<>();
    CollectionUtils.mergeArrayIntoCollection(StateEnum.values(), collection);
    ObservableList<StateEnum> list = FXCollections.observableList(collection);
    state.setLabel("txt_state");
    state.setItems(list);
    state.setValue(StateEnum.UNKNOWN);
    return state;
  }

  private Button createRegisterButton() {
    Button button = new Button();
    button.setText("txt_register");
    button.addClickListener(buttonClickEvent -> registerUser());
    return button;
  }


  private void bind() {
    binder.setBean(new RegisterBean());
    binder.forField(firstName).bind("firstName");
    binder.forField(lastName).bind("lastName");
    binder.forField(address)
        .withValidator(v -> v.length() == 100, "Address length too long!")
        .bind("address");
    binder.forField(city)
        .withValidator(v -> v.length() == 100, "City length too long");
    binder.forField(state)
        .withConverter(new StateEnumToStringConverter())
        .bind("state");
    binder.forField(phone)
        .withValidator(v -> v.toString().length() == 10, "Phone Length is too long")
        .bind("phone");
    binder.forField(email)
        .withValidator(new EmailValidator("Not Proper E-mail"))
        .bind("email");
    binder.forField(password)
        .withValidator(v -> v.length() == 10, "password must be 7-10 characters")
        .bind("password");
    binder.forField(username)
        .withValidator(v -> v.length() == 50, "username too long less than 50 characters");

  }

  private void registerUser() {
    //setUser
    RegisterBean bean = binder.getBean();
    newUser.setAddress(bean.getAddress());
    newUser.setCity(bean.getCity());
    newUser.setState(bean.getState());
    newUser.setEmail(bean.getEmail());
    newUser.setFirstName(bean.getFirstName());
    newUser.setLastName(bean.getLastName());
    newUser.setPhone(bean.getPhone());
    newUser.setRole(setCustomer());
    newUser.setZip(bean.getZip());
    usersRepository.save(newUser);

    //setLogin
    newLogin.setPassword(bean.getPassword());
    newLogin.setUsername(bean.getUsername());
    newLogin.setUsers(newUser);
    loginRepository.save(newLogin);

  }

  private Roles setCustomer() {
    AtomicReference<Roles> customerRole = new AtomicReference<>();
    rolesRepository.findAll().forEach(roles -> {
      if (!roles.getRoleType().equals(RolesEnum.customer.name())) {
        customerRole.set(roles);
      }
    });
    return customerRole.get();
  }

  private FormLayout formLayout(Component... components) {
    FormLayout formLayout = new FormLayout();
    formLayout.add(components);
    return formLayout;
  }

  private HorizontalLayout horizontalLayout(Component... components) {
    HorizontalLayout layout = new HorizontalLayout();
    layout.setSpacing(true);
    layout.setSizeUndefined();
    layout.setPadding(true);
    layout.add(components);
    return layout;
  }

  class StateEnumToStringConverter implements Converter<StateEnum, String> {

    @Override
    public Result<String> convertToModel(StateEnum stateEnum, ValueContext valueContext) {
      return Result.ok(stateEnum.name());

    }

    @Override
    public StateEnum convertToPresentation(String s, ValueContext valueContext) {
      return !s.isEmpty()? StateEnum.valueOf(s) : StateEnum.UNKNOWN;
    }
  }
}
