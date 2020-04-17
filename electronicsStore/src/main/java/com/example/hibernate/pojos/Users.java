package com.example.hibernate.pojos;

import com.example.hibernate.pojos.Roles;
import java.math.BigDecimal;
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
@Table(name = "users")
public class Users {

  @Id
  @Column(name = "userId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "user_address", length = 100)
  private String address;
  @Column(name = "city", length = 100)
  private String city;
  @Column(name = "user_state", length = 100)
  private String state;
  @Column(name = "phone", precision = 10)
  private BigDecimal phone;
  @ManyToOne
  private Roles role;

}
