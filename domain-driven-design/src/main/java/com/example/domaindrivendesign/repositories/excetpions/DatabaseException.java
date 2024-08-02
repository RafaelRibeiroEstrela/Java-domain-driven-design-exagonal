package com.example.domaindrivendesign.repositories.excetpions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }
}
