package com.vnk.speakivcore.response.result;

public class DataResultBody<T> extends ResultBody {
    private T data;
    public DataResultBody(boolean success) {
        super(success);
    }

    public DataResultBody(boolean success, String message) {
        super(success, message);
    }

    public DataResultBody(boolean success, String message, T data){
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
