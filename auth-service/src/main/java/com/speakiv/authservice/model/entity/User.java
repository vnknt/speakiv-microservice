package com.speakiv.authservice.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

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

    @ManyToMany
    private Collection<UserRole> roles;
}
