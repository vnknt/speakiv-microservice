package com.speakiv.authservice.api;

import com.speakiv.authservice.model.AuthRequest;
import com.speakiv.authservice.model.AuthResponse;
import com.speakiv.speakivcore.model.response.DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/auth")
public class AuthApi {

    @PostMapping("/login")
    ResponseEntity<DataResponse<AuthResponse>> login(AuthRequest request){
        return ResponseEntity.ok(null);
    }


}