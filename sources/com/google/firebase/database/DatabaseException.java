package com.google.firebase.database;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String str) {
        super(str);
    }

    public DatabaseException(String str, Throwable th2) {
        super(str, th2);
    }
}
