package com.example.Seguimiento_Reguimen.util;

public class ApiRespose <T> {
    private int status;
    private String message;
    private T Data;

    public ApiRespose(int status, String message, T data) {
        this.status = status;
        this.message = message;
        Data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
