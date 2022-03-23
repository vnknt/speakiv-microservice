package com.speakiv.socialservice.api;

import com.speakiv.socialservice.model.request.MessageSendRequest;
import com.speakiv.speakivcore.model.response.Response;
import com.speakiv.speakivcore.model.response.SuccessResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/message")
public class MessageApi {

    @PostMapping("/send")
    public Response send(@RequestBody MessageSendRequest request){
    Response response =new SuccessResponse();

    return response;
    }

}
