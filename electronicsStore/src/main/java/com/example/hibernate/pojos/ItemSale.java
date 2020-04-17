package com.example.hibernate.pojos;

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
@Table(name="sale")
public class ItemSale {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "saleId")
  private Integer saleId;
  @ManyToOne
  private Item item;
  @Column(name = "quantity")
  private Integer quantity;
  @ManyToOne
  private Reciept reciept;
}
