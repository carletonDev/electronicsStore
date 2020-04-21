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
@Table(name = "users", schema = "dbo")
public class Users implements Serializable {

  private static final long serialVersionUID = -2920276092638972623L;
  @Id
  @Column(name = "userid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;
  @Column(name = "first_name", columnDefinition = "NVARCHAR(MAX)")
  private String firstName;
  @Column(name = "last_name", columnDefinition = "NVARCHAR(MAX)")
  private String lastName;
  @Column(name = "user_address", length = 100, columnDefinition = "NVARCHAR(100)")
  private String address;
  @Column(name = "city", length = 100, columnDefinition = "NVARCHAR(100)")
  private String city;
  @Column(name = "user_state", length = 100, columnDefinition = "NVARCHAR(100)")
  private String state;
  @Column(name = "phone", precision = 10, columnDefinition = "NUMERIC(10,0)")
  private Number phone;
  @ManyToOne
  @JoinColumn(name = "roleid", insertable = false, updatable = false)
  private Roles role;
  @Column(name = "email", length = 250, columnDefinition = "NVARCHAR(250)")
  private String email;

}
