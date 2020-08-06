package com.store.electronicsStore.hibernate.pojos;

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
@Table(name = "schedule", schema = "dbo")
public class Schedule {

  @Id
  @Column(name = "scheduleId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer scheduleId;

  @Column(name = "time_in")
  private LocalDateTime timeIn;

  @Column(name = "time_out")
  private LocalDateTime timeOut;
  @ManyToOne
  @JoinColumn(name = "userid", insertable = false, updatable = false)
  private Users user;
}
