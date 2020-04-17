package com.store.hibernate.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "roles")
public class Roles implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "roleid")
  private Integer roleId;
  @Column(name = "role_type", nullable = false, length = 100,columnDefinition = "NVARCHAR(100)")
  private String roleType;
}
