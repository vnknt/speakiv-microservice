package com.speakiv.accountservice.model.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class UserRegisterDto  {
    private String id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2,max=20,message = "Name must be between 2 and 20 characters")
    private String name;

    @NotNull(message = "Surname cannot be null")
    @Size(min = 2,max=20,message = "Surname must be between 2 and 20 characters")
    private String surname;

    @NotNull(message="Username cannot be null")
    @Size(min = 2,max=20,message = "Username must be between 2 and 20 characters")
    private String username;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email is not valid")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6,max=20,message = "Password must be between 6 and 20 characters")
    private String password;
}
