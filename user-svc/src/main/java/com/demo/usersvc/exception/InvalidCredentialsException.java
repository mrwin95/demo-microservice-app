package com.demo.usersvc.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String msg){
        super(msg);
    }
}
