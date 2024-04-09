package com.bloom.exception;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
