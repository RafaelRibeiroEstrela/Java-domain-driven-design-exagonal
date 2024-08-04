package com.example.domaindrivendesign.infrastructure.repositories.excetpions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }
}
