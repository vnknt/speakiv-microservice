package com.speakiv.socialservice.model.dto;

import com.speakiv.socialservice.model.entity.ActiveUser;
import lombok.Data;


@Data
public class RoomDto {

    private String title;

    private String language;

    private Integer maxCapacity;

}
