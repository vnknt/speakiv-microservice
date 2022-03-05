package com.vnk.speakivcore.resultbody;

public class ErrorResultBody extends ResultBody {
    public ErrorResultBody() {
        super(false);
    }

    public ErrorResultBody(boolean success, String message) {
        super(success, message);
    }
}
