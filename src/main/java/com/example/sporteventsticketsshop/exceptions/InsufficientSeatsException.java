package com.example.sporteventsticketsshop.exceptions;

public class InsufficientSeatsException extends Exception {
    public InsufficientSeatsException() {}

    public InsufficientSeatsException(String message) {
        super(message);
    }
}
