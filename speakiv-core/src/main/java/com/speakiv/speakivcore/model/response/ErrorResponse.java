package com.speakiv.speakivcore.model.response;

public class ErrorResponse extends Response {
    public ErrorResponse() {
        super(false);
    }

    public ErrorResponse(boolean success, String message) {
        super(success, message);
    }
}
