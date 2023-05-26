package com.example.sporteventsticketsshop.exceptions;

public class EventAlreadyExistException extends RuntimeException {
    public EventAlreadyExistException() {
    }

    public EventAlreadyExistException(String message) {
        super(message);
    }
}
