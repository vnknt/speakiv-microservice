package com.speakiv.accountservice.model.request;

import com.speakiv.speakivcore.model.request.TokenRequest;
import lombok.Data;

@Data
public class UpdateDescriptionRequest extends TokenRequest {
    private Long userId;
    private String description;
}
