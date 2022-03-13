package com.speakiv.socialservice.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="room_messages")
public class RoomMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_id",nullable = false)
    private Long roomId;

    @Column(name="sender_id",nullable = false)
    private Long senderId;

    @Column(name="date",nullable = false)
    private Date date;

}
