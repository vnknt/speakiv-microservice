package com.vnk.speakivcore.response.result;

public class SuccessDataResultBody<T> extends DataResultBody<T>{
    public SuccessDataResultBody() {
        super(true);
    }

    public SuccessDataResultBody(boolean success, String message) {
        super(success, message);
    }

    public SuccessDataResultBody(boolean success, String message, T data) {
        super(success, message, data);
    }
}
