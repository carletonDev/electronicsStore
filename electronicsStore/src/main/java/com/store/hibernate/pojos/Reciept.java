package com.store.hibernate.pojos;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "reciept")
public class Reciept implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "recieptid")
  private Integer itemId;
  @Column(name = "date_sold", nullable = false)
  private LocalDateTime dateSold;
  @ManyToOne(optional = false)
  @JoinColumn(name="employeeid",insertable = false,updatable = false)
  private Users employee;
  @ManyToOne(optional = false)
  @JoinColumn(name="customerid",insertable = false,updatable = false)
  private Users customer;
}
