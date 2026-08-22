package com.digipay.digitalwallet.globalexception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String ex) {
        super(ex);
    }
}
