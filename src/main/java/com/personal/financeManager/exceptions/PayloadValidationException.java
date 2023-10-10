package com.personal.financeManager.exceptions;

public class PayloadValidationException extends RuntimeException {
    public PayloadValidationException(String msg) {
        super(msg);
    }
}
