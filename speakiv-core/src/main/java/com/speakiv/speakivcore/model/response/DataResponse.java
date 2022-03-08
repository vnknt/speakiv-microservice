package com.speakiv.speakivcore.model.response;

public class DataResponse<T> extends Response {
    private T data;
    public DataResponse(boolean success) {
        super(success);
    }

    public DataResponse(boolean success, String message) {
        super(success, message);
    }

    public DataResponse(boolean success, String message, T data){
        super(success,message);
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
