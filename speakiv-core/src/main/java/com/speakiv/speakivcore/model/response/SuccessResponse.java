package com.speakiv.speakivcore.model.response;

public class SuccessResponse extends Response {
    public SuccessResponse() {
        super(true);
    }

    public SuccessResponse(String message) {
        super(true, message);
    }
}
