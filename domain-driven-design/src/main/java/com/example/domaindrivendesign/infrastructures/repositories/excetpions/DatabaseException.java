package com.example.domaindrivendesign.infrastructures.repositories.excetpions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }
}
