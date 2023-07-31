package com.hung.cozastore.exception;

public class customException extends RuntimeException{
    private String message;
    public customException(String message) {
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
