package com.speakiv.speakivcore.model.response;

public class SuccessDataResponse<T> extends DataResponse<T> {
    public SuccessDataResponse() {
        super(true);
    }

    public SuccessDataResponse( String message) {
        super(false, message);
    }

    public SuccessDataResponse( String message, T data) {
        super(false, message, data);
    }
}
