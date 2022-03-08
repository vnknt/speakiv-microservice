package com.speakiv.accountservice.model.request;

import com.speakiv.accountservice.model.dto.UserRegisterDto;
import lombok.Data;

@Data
public class UserRegisterRequest {
    private UserRegisterDto registerInfo;
}
