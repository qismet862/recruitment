package com.recruitment.exception;

public class UniqueUserName extends RuntimeException {
    public UniqueUserName(String message) {
        super(message);
    }
}
