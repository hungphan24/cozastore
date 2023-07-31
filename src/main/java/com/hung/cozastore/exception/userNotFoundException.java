package com.hung.cozastore.exception;

public class userNotFoundException extends RuntimeException{

    private String message;
    public userNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
