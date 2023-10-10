package com.personal.financeManager.exceptions;

public class DocumentAlreadyExistsException extends RuntimeException {
    public DocumentAlreadyExistsException(String msg) {
        super(msg);
    }
}
