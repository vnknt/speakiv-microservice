package com.speakiv.socialservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rooms")
@Data
public class Room {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="creator_id",nullable = false)
    private Long creatorId;

    @Column(name="created_date",nullable = false)
    private Date createdDate;

    @Column(name="max_capacity",nullable = false)
    private Integer maxCapacity;

    @OneToMany
    private List<ActiveUser> activeUsers;
}
