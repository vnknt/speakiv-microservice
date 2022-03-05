package com.vnk.speakivcore.response.result;

public class ErrorResultBody extends ResultBody {
    public ErrorResultBody() {
        super(false);
    }

    public ErrorResultBody(boolean success, String message) {
        super(success, message);
    }
}
