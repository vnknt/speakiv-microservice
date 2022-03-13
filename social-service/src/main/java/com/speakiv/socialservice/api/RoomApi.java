package com.speakiv.socialservice.api;

import com.speakiv.socialservice.model.dto.RoomDto;
import com.speakiv.socialservice.model.request.CreateRoomRequest;
import com.speakiv.socialservice.model.request.UserRoomActionRequest;
import com.speakiv.speakivcore.model.response.DataResponse;
import com.speakiv.speakivcore.model.response.Response;
import com.speakiv.speakivcore.model.response.SuccessDataResponse;
import com.speakiv.speakivcore.model.response.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/room")
public class RoomApi {

    @PostMapping("/create")
    public ResponseEntity<Response> createRoom(@RequestBody CreateRoomRequest request){
        Response response = new SuccessResponse() ;
        return ResponseEntity.ok(response);
    }

    @PostMapping("/join")
    public ResponseEntity<Response> joinRoom(@RequestBody UserRoomActionRequest request){
        Response response = new SuccessResponse() ;
        return ResponseEntity.ok(response);
    }

    @PostMapping("/leave")
    public ResponseEntity<Response> leaveRoom(@RequestBody UserRoomActionRequest request){
        Response response = new SuccessResponse() ;
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<DataResponse<RoomDto>> getRoomDetail(@PathVariable(name= "id") String id){
        DataResponse<RoomDto> response = new SuccessDataResponse<>();
        return ResponseEntity.ok(response);
    }



}
