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
@Table(name="sale")
public class Sale implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "saleid")
  private Integer saleId;
  @ManyToOne
  @JoinColumn(name="itemid",insertable = false,updatable = false)
  private Item item;
  @Column(name = "quantity")
  private Integer quantity;
  @ManyToOne
  @JoinColumn(name="recieptid",insertable = false,updatable = false)
  private Reciept reciept;
}
