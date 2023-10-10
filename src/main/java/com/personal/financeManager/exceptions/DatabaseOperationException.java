package com.personal.financeManager.exceptions;

public class DatabaseOperationException extends RuntimeException {
    public DatabaseOperationException(String msg) {
        super(msg);
    }
}
