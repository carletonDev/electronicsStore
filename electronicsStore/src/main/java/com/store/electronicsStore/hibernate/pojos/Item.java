package com.store.electronicsStore.hibernate.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "itemid")
  private Integer itemId;
  @Column(name = "part_name", nullable = false
    ,columnDefinition = "NVARCHAR(MAX)")
  private String itemName;
  @Column(name = "part_type", length = 100, columnDefinition = "NVARCHAR(100)")
  private String type;
  @Column(name = "cost", scale = 10, precision = 2, nullable = false
      , columnDefinition = "DECIMAL(10,2)")
  private BigDecimal cost;
  @Column(name = "quantity")
  private Integer quantity;
}
