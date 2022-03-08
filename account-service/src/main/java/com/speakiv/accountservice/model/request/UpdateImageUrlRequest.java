package com.speakiv.accountservice.model.request;

import com.speakiv.speakivcore.model.request.TokenRequest;
import lombok.Data;

@Data
public class UpdateImageUrlRequest extends TokenRequest {
    private String imageUrl;
    private Long userId;
}
