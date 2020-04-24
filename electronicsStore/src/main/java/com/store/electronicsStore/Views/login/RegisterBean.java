package com.store.electronicsStore.Views.login;

import java.io.Serializable;
import lombok.Data;

@SuppressWarnings("WeakerAccess")
@Data
public class RegisterBean implements Serializable {


  private static final long serialVersionUID = -1191401781942882459L;
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String state;
  private String phone;
  private String email;
  private String password;
  private String username;
  private Integer zip;

  public RegisterBean() {

  }

}
