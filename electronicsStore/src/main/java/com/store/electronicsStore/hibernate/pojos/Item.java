package com.store.electronicsStore.hibernate.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "item" ,schema = "dbo")
public class Item implements Serializable {

  private static final long serialVersionUID = 2484915733355484677L;
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
  @Lob
  @Column(name="image")
  private Blob image;

  //todo add item attachments
}
