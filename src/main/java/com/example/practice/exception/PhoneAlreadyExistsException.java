package com.example.practice.exception;

public class PhoneAlreadyExistsException extends RuntimeException {

    public PhoneAlreadyExistsException()
    {
        super("Phone number already exists");
    }
}
