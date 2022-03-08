package com.speakiv.speakivcore.model.response;

public class ErrorDataResponse<T> extends DataResponse<T> {
    public ErrorDataResponse() {
        super(false);
    }

    public ErrorDataResponse( String message) {
        super(false, message);
    }

    public ErrorDataResponse(String message, T data) {
        super(false, message, data);
    }
}
