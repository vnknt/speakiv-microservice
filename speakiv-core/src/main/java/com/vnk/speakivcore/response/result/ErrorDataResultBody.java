package com.vnk.speakivcore.response.result;

public class ErrorDataResultBody<T> extends DataResultBody<T> {
    public ErrorDataResultBody() {
        super(false);
    }

    public ErrorDataResultBody(boolean success, String message) {
        super(success, message);
    }

    public ErrorDataResultBody(boolean success, String message, T data) {
        super(success, message, data);
    }
}
