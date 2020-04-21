package com.store.electronicsStore.hibernate.pojos;

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
@Table(name = "reciept",schema = "dbo")
public class Reciept implements Serializable {

  private static final long serialVersionUID = -1480283610440430268L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "recieptid")
  private Integer itemId;
  @Column(name = "date_sold", nullable = false)
  private LocalDateTime dateSold=LocalDateTime.now();
  @ManyToOne(optional = false)
  @JoinColumn(name="employeeid",insertable = false,updatable = false)
  private Users employee;
  @ManyToOne(optional = false)
  @JoinColumn(name="customerid",updatable = false)
  private Users customer;
}
