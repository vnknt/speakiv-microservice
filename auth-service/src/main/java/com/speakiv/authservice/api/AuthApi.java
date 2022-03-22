package com.speakiv.authservice.api;

import com.speakiv.authservice.model.AuthRequest;
import com.speakiv.authservice.model.AuthResponse;
import com.speakiv.authservice.model.TokenValidationResponse;
import com.speakiv.authservice.service.AuthService;
import com.speakiv.speakivcore.model.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/auth")
public class AuthApi {
    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    ResponseEntity<DataResponse<AuthResponse>> login(@RequestBody AuthRequest request){
        DataResponse<AuthResponse> response= authService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/validateToken")
    ResponseEntity<DataResponse<TokenValidationResponse>> validateToken(@RequestParam(name="token") String  token){
        DataResponse<TokenValidationResponse> response= authService.validateToken(token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refreshToken")
    ResponseEntity<DataResponse<AuthResponse>> refreshToken(@RequestBody AuthRequest request){
        DataResponse<AuthResponse> response= authService.login(request);
        return ResponseEntity.ok(response);
    }

}