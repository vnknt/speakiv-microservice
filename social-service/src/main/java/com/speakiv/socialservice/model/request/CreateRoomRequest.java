package com.speakiv.socialservice.model.request;

import com.speakiv.socialservice.model.dto.RoomDto;
import com.speakiv.speakivcore.model.request.TokenRequest;
import lombok.Data;

@Data
public class CreateRoomRequest extends TokenRequest {
    private String title;

    private String language;

    private Integer maxCapacity;
}
