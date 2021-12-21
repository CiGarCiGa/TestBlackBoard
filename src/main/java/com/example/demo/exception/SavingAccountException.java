package com.example.demo.exception;

public class SavingAccountException extends Exception {
    public SavingAccountException(String errorMessage) {
        super(errorMessage);
    }
}