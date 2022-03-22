package com.speakiv.authservice.service;

import com.speakiv.authservice.model.AuthRequest;
import com.speakiv.authservice.model.AuthResponse;
import com.speakiv.authservice.model.TokenValidationResponse;
import com.speakiv.authservice.security.TokenManager;
import com.speakiv.speakivcore.model.response.DataResponse;
import com.speakiv.speakivcore.model.response.ErrorDataResponse;
import com.speakiv.speakivcore.model.response.SuccessDataResponse;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public DataResponse<AuthResponse> login(AuthRequest request){
        AuthResponse authResponse = new AuthResponse();
        DataResponse<AuthResponse> response = new SuccessDataResponse<>();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        }catch (BadCredentialsException exception){
            throw exception;
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String accessToken = tokenManager.generateToken(userDetails);
        authResponse.setAccessToken(accessToken);
        response.setData(authResponse);
        return response;
    }


    public DataResponse<TokenValidationResponse> validateToken(String token){
        DataResponse<TokenValidationResponse> response =new SuccessDataResponse<>();


        TokenValidationResponse tokenValidationResponse = new TokenValidationResponse();
        try{


            String subject = tokenManager.extractSubject(token);
            boolean isTokenValid = tokenManager.isTokenValid(token,subject);
            if(!isTokenValid){
                response=new ErrorDataResponse<>();
                return response;
            }
            List<String> roles = tokenManager.extractRoles(token);
            tokenValidationResponse.setRoles(roles);
            tokenValidationResponse.setUserId(Long.parseLong(subject));
            response.setData(tokenValidationResponse);
        }catch (JwtException e){
            response = new ErrorDataResponse<>();
        }
        return response;
    }



}
