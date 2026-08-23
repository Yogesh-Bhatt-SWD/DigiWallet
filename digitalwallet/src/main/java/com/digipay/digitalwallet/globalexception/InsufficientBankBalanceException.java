package com.digipay.digitalwallet.globalexception;

public class InsufficientBankBalanceException extends RuntimeException{
    public InsufficientBankBalanceException(String ex) {
        super(ex);
    }
}
