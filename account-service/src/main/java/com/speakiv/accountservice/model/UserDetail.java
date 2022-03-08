package com.speakiv.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table
@Data
@Entity
@JsonIgnoreProperties(  {"hibernateLazyInitiliazer","handler","user"})
public class UserDetail {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="profile_picture_url")
    private String profilePictureUrl;

    @Column(name="profile_description")
    private String profileDescription;

    @Column(name = "registered_at")
    private Date registredAt;

}
