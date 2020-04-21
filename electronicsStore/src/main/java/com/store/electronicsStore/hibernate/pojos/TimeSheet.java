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
@Table(name="timesheet",schema = "dbo")
public class TimeSheet implements Serializable {

  private static final long serialVersionUID = -5894008789931079572L;

  @Id
  @Column(name="timeid")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer timeId;

  @ManyToOne
  @JoinColumn(name="userid",insertable = false,updatable = false)
  private Users users;

  @Column(name="time_in")
  private LocalDateTime timeIn;

  @Column(name="time_out")
  private LocalDateTime timeOut;
}
