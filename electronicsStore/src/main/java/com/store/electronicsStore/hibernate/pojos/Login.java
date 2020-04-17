package com.store.electronicsStore.hibernate.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="login_users")
public class Login implements Serializable {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="loginid")
  private Integer loginId;
  @Column(name="username",length =100,columnDefinition = "NVARCHAR(100)")
  private String username;
  @Column(name="pass",length = 10,columnDefinition = "NVARCHAR(10)")
  private String password;
  @ManyToOne(optional = false)
  @JoinColumn(name="userid",insertable = false,updatable = false)
  private Users users;

}
