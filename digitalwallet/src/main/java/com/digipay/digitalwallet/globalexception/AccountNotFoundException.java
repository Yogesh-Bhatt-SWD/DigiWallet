package com.digipay.digitalwallet.globalexception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String ex) {
        super(ex);
    }
}
