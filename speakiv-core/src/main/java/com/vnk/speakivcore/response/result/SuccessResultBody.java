package com.vnk.speakivcore.response.result;

public class SuccessResultBody extends ResultBody {
    public SuccessResultBody() {
        super(true);
    }

    public SuccessResultBody(String message) {
        super(true, message);
    }
}
