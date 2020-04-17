package com.store.hibernate.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="login_users")
public class Login implements Serializable {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="loginId")
  private Integer loginId;
  @Column(name="username",length =100)
  private String username;
  @Column(name="pass",length = 10)
  private String password;
  @ManyToOne(optional = false)
  private Users users;

}
