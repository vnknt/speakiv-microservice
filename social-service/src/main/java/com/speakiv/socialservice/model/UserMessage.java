package com.speakiv.socialservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_messages")
@Data
public class UserMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="sender_id",nullable = false)
    private Long senderId;

    @Column(name="receiver_id",nullable = false)
    private Long receiverId;

    @Column(name="message",nullable = false)
    private String message;

    @Column(name = "date",nullable = false)
    private Date date;
}
