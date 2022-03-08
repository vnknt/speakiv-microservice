package com.speakiv.speakivcore.model.response;

public class Response {
    private boolean success;
    private String message;
    public Response(boolean success){
        this.success=success;
    }
    public Response(boolean success , String message){
        this.message=message;
        this.success=success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
