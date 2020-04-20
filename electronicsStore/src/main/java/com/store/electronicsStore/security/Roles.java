package com.store.electronicsStore.security;

public enum Roles {
  admin("Admin"),
  employee("Employee"),
  customer("Customer");
  private String roleType;

  Roles(String roleType){
    this.roleType=roleType;
  }
}
