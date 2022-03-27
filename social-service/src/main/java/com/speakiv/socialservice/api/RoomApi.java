package com.speakiv.socialservice.api;

import com.speakiv.socialservice.model.dto.RoomDto;
import com.speakiv.socialservice.model.entity.Room;
import com.speakiv.socialservice.model.request.CreateRoomRequest;
import com.speakiv.socialservice.service.RoomService;
import com.speakiv.speakivcommon.utils.AuthUtil;
import com.speakiv.speakivcore.model.response.DataResponse;
import com.speakiv.speakivcore.model.response.Response;
import com.speakiv.speakivcore.model.response.SuccessDataResponse;
import com.speakiv.speakivcore.model.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/room")
public class RoomApi {
    @Autowired
    private RoomService roomService;
    @PostMapping("/create")
    public ResponseEntity<Response> createRoom(@RequestBody CreateRoomRequest request){
        Response response ;
        Long userId = AuthUtil.getUserIdFromSecurityContext(SecurityContextHolder.getContext());

        RoomDto roomDto = new RoomDto();
        roomDto.setTitle(request.getTitle());
        roomDto.setLanguage(request.getLanguage());
        roomDto.setMaxCapacity(request.getMaxCapacity());
        response = roomService.createRoom(roomDto,userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<DataResponse<RoomDto>> getRoomDetail(@PathVariable(name= "id") String id){
        DataResponse<RoomDto> response = new SuccessDataResponse<>();
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<DataResponse<List<Room>>> getAll(){
        DataResponse<List<Room>> response = this.roomService.getAll();
        return ResponseEntity.ok(response);
    }


}
