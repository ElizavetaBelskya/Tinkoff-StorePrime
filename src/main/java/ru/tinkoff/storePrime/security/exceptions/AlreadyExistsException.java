package ru.tinkoff.storePrime.security.exceptions;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
    public AlreadyExistsException(String message){
        super(message);
    }
}
