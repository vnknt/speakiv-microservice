package com.speakiv.socialservice.service;

import com.speakiv.socialservice.model.dto.RoomDto;
import com.speakiv.socialservice.model.entity.Room;
import com.speakiv.socialservice.repository.LanguageRepository;
import com.speakiv.socialservice.repository.RoomRepository;
import com.speakiv.speakivcore.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private LanguageRepository languageRepository;


    public DataResponse<List<Room>> getAll(){
        DataResponse<List<Room>> response = new SuccessDataResponse<>();
        List<Room> roomList  =this.roomRepository.findAll();
        response.setData(roomList);
        return response;
    }

    public DataResponse<Room> getById(Long id){
        DataResponse<Room> response;
        Optional<Room> roomOpt = roomRepository.findById(id);
        if(roomOpt.isEmpty()){
            response=new ErrorDataResponse<>();
            return response;
        }
        response=new SuccessDataResponse<>();
        response.setData(roomOpt.get());
        return response;
    }


    public Response createRoom(RoomDto roomDetail,Long userId){
        Response response ;

        Room room = convertRoomDto(roomDetail);
        room.setCreatorId(userId);
        try{
            roomRepository.save(room);
            response = new SuccessResponse();
        }catch (Exception e){
            response=new ErrorResponse();
        }
        return response;
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
