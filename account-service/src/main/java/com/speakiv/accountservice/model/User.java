package com.speakiv.accountservice.model;

import lombok.Data;

import javax.persistence.*;


@Table(name = "Users")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="username",nullable = false)
    private String username;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="is_active",nullable = false)
    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private UserDetail userDetail;

}
