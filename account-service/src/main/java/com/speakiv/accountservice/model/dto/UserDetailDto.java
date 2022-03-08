package com.speakiv.accountservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDetailDto {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String profilePictureUrl;
    private String profileDescription;
}
