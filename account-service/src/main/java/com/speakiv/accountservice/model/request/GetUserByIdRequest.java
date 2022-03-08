package com.speakiv.accountservice.model.request;

import com.speakiv.speakivcore.model.request.TokenRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserByIdRequest extends TokenRequest {
    private Long userId;
}
