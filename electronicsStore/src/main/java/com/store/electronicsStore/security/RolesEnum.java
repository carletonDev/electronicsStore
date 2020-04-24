package com.store.electronicsStore.security;

public enum RolesEnum {
  admin("Admin"),
  employee("Employee"),
  customer("Customer");
  public String roleType;

  RolesEnum(String roleType){
    this.roleType=roleType;
  }
}
