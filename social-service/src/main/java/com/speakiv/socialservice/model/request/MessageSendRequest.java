package com.speakiv.socialservice.model.request;

public class MessageSendRequest {
    private Long receiver;
    private String message;

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
