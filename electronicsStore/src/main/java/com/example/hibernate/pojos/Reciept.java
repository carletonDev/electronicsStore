package com.example.hibernate.pojos;

import java.time.LocalDateTime;
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
@Table(name = "reciept")
public class Reciept {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "recieptId")
  private Integer itemId;
  @Column(name = "date_sold", nullable = false)
  private LocalDateTime dateSold;
  @ManyToOne(optional = false)
  private Users employee;
  @ManyToOne(optional = false)
  private Users customer;
}
