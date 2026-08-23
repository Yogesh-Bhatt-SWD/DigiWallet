package com.digipay.digitalwallet.globalexception;

public class InvalidAccountStatusException extends RuntimeException{
    public InvalidAccountStatusException(String ex) {
        super(ex);
    }
}
