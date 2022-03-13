package com.speakiv.socialservice.service;

import com.speakiv.socialservice.model.dto.RoomDto;
import com.speakiv.socialservice.model.entity.Room;
import com.speakiv.socialservice.repository.LanguageRepository;
import com.speakiv.socialservice.repository.RoomRepository;
import com.speakiv.speakivcore.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class RoomService {
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private LanguageRepository languageRepository;




    public Response createRoom(RoomDto roomDetail,Long userId){
        Response response ;

        Room room = convertRoomDto(roomDetail);
        room.setCreatorId(userId);

        return null;
    }

    private Room convertRoomDto(RoomDto dto){
        Room room = new Room();
        room.setActiveUsers(new ArrayList<>());
        room.setCreatedDate(new Date());
        room.setTitle(dto.getTitle());
        room.setMaxCapacity(dto.getMaxCapacity());
        room.setLanguage(languageRepository.findLanguageByLanguageCode(dto.getLanguage()));
        return room;
    }


}
