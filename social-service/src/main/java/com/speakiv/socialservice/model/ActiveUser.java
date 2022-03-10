package com.speakiv.socialservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class ActiveUser {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="joined_date")
    private Date joinedDate;

    @Column(name="is_creator")
    private Boolean isCreator;


}
