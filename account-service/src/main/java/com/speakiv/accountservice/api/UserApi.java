package com.speakiv.accountservice.api;

import com.speakiv.accountservice.model.dto.UserDetailDto;
import com.speakiv.accountservice.model.dto.UserRegisterDto;
import com.speakiv.accountservice.model.request.GetUserByIdRequest;
import com.speakiv.accountservice.model.request.UpdateDescriptionRequest;
import com.speakiv.accountservice.service.UserService;
import com.speakiv.speakivcore.model.response.DataResponse;
import com.speakiv.speakivcore.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("api/user")
public class UserApi {


    @Autowired
    private UserService userService;


    @PostMapping("/getAll")
    public ResponseEntity<DataResponse<List<UserDetailDto>>> getAll(){
        DataResponse<List<UserDetailDto>> response = this.userService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/getById")
    public ResponseEntity<DataResponse<UserDetailDto>> getById(@RequestBody GetUserByIdRequest request){
        DataResponse<UserDetailDto> response = this.userService.getById(request.getUserId());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/update/image")
    public ResponseEntity<Response> updateImage(@RequestBody UpdateDescriptionRequest request){
        Response response = this.userService.updateProfileImageUrl(request.getUserId(), request.getDescription());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/update/profileDescription")
    public ResponseEntity<Response> updateProfileDescription(@RequestBody UpdateDescriptionRequest request){
        Response response = this.userService.updateProfileDescription(request.getUserId(),request.getDescription());
        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody UserRegisterDto userDetail){
        Response response = this.userService.save(userDetail);
        return ResponseEntity.ok().body(response);
    }



}
