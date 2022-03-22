package com.speakiv.authservice.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserRoles")
@Data
public class UserRole {

    @Id
    private Long id;

    @Column(name="role_name")
    private String roleName;
}
