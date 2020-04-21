package com.store.electronicsStore.hibernate.pojos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "login_users", schema = "dbo", uniqueConstraints = @UniqueConstraint(name = "PK__login_us__1F5EF4CF8294DAD4", columnNames = "loginid"))
    public class Login implements Serializable {

    private static final long serialVersionUID = 5933923707673163232L;
    @Id
    @Column(name = "loginid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loginId;
    @Column(name = "username", length = 100)
    private String username;
    @Column(name = "pass", length = 10)
    private String password;
    @ManyToOne(optional = false,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private Users users;

    }
