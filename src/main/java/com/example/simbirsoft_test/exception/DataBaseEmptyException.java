package com.example.simbirsoft_test.exception;

public class DataBaseEmptyException extends RuntimeException{
    public DataBaseEmptyException() {
        super("Database is empty");
    }
}
