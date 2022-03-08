package com.speakiv.accountservice.service;

import com.speakiv.accountservice.model.User;
import com.speakiv.accountservice.model.UserDetail;
import com.speakiv.accountservice.model.dto.UserDetailDto;
import com.speakiv.accountservice.model.dto.UserRegisterDto;
import com.speakiv.accountservice.repository.UserRepository;
import com.speakiv.speakivcore.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Response save(UserRegisterDto userRegisterDto){
        Response response;

        User user = this.convertUser(userRegisterDto);
        response = new SuccessResponse();
        try{
            this.userRepository.save(user);
        }catch (Exception e){
            response = new ErrorResponse();
            response.setMessage("Error during registration");
        }
        return response;
    }



    public DataResponse<List<UserDetailDto>> getAll(){
        SuccessDataResponse<List<UserDetailDto>> response = new SuccessDataResponse<>();
        List<User> userDetailList = this.userRepository.findAll();
        List<UserDetailDto> userDetailDtos = userDetailList.stream()
                .map(this::convertUserDetailDto)
                .collect(Collectors.toList());
        response.setData(userDetailDtos);
        return response;

    }



    public DataResponse<UserDetailDto> getById(Long userId){
        DataResponse response ;
        Optional<User> user = this.userRepository.findById(userId);
        if(!user.isPresent()) {
            response= new ErrorDataResponse("User not found");
            return response;
        }

        response  =new SuccessDataResponse();
        response.setData(convertUserDetailDto(user.get()));
        return response;
    }



    public Response updateProfileImageUrl(Long userId, String url){
        Response response ;
        Optional<User> userOptional = this.userRepository.findById(userId);

        if(!userOptional.isPresent()) {
            response= new ErrorDataResponse("User not found");
            return response;
        }
        try{
            User user = userOptional.get();
            user.getUserDetail().setProfilePictureUrl(url);
            this.userRepository.save(user);
        }catch (Exception e){
            response=new ErrorDataResponse("Unexpected Error Occured");
            return response;
        }

        response  =new SuccessDataResponse();
        return response;
    }

    public Response updateProfileDescription(Long userId,String description){
        Response response ;
        Optional<User> userOptional = this.userRepository.findById(userId);
        
        if(!userOptional.isPresent()) {
            response= new ErrorDataResponse("User not found");
            return response;
        }
        try{
            User user = userOptional.get();
            user.getUserDetail().setProfileDescription(description);
            this.userRepository.save(user);
        }catch (Exception e){
            response=new ErrorDataResponse("Unexpected Error Occured");
            return response;
        }
        response  =new SuccessDataResponse();
        return response;

    }



    public Response deleteAll(){

        List<User> userList = this.userRepository.findAll();
        for(User user:userList){
            this.userRepository.delete(user);
        }

        return new SuccessResponse();
    }



    public UserDetailDto convertUserDetailDto(User user){
        UserDetailDto userDetailDto = new UserDetailDto();
        userDetailDto.setId(user.getId());
        userDetailDto.setName(user.getUserDetail().getName());
        userDetailDto.setSurname(user.getUserDetail().getSurname());
        userDetailDto.setUsername(user.getUsername());
        userDetailDto.setEmail(user.getEmail());
        userDetailDto.setProfilePictureUrl(user.getUserDetail().getProfilePictureUrl());
        userDetailDto.setProfileDescription(user.getUserDetail().getProfileDescription());
        return userDetailDto;
    }




    public User convertUser(UserRegisterDto dto){
        UserDetail userDetail = new UserDetail();
        User user = new User();

        userDetail.setName(dto.getName());
        userDetail.setSurname(dto.getSurname());
        userDetail.setProfilePictureUrl("https://cdn-icons-png.flaticon.com/512/149/149071.png");
        userDetail.setProfileDescription("");
        userDetail.setRegistredAt(new Date());


        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setIsActive(true);


        user.setUserDetail(userDetail);
        return user;
    }


}
