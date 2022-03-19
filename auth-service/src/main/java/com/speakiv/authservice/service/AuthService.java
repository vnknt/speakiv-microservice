package com.speakiv.authservice.service;

import com.speakiv.authservice.model.AuthRequest;
import com.speakiv.authservice.model.AuthResponse;
import com.speakiv.speakivcore.model.response.DataResponse;
import com.speakiv.speakivcore.model.response.SuccessDataResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public DataResponse<AuthResponse> login(AuthRequest request){
        DataResponse<AuthResponse> response = new SuccessDataResponse<>();

        return response;
    }

}
