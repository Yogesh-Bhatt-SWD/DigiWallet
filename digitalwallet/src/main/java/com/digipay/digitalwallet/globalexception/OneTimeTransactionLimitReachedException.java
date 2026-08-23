package com.digipay.digitalwallet.globalexception;

public class OneTimeTransactionLimitReachedException extends RuntimeException{
    public OneTimeTransactionLimitReachedException(String ex) {
        super(ex);
    }
}
