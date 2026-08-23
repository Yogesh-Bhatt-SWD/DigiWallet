package com.digipay.digitalwallet.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userHandler(UserNotFoundException ex ) {
        return ResponseEntity.status(
                HttpStatus.NOT_FOUND
        ).body(ex.getMessage());
    }
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> AccountHandler(AccountNotFoundException ex) {
        return ResponseEntity.status(
                HttpStatus.NOT_FOUND
        ).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidAccountStatusException.class)
    public ResponseEntity<String> statusHandler(InvalidAccountStatusException ex) {
        return ResponseEntity.status(
                HttpStatus.FORBIDDEN
        ).body(ex.getMessage());
    }
    @ExceptionHandler(InsufficientBankBalanceException.class)
    public ResponseEntity<String> balanceHandler(InsufficientBankBalanceException ex) {
        return ResponseEntity.status(
                HttpStatus.BAD_REQUEST
        ).body(ex.getMessage());
    }
    @ExceptionHandler(OneTimeTransactionLimitReachedException.class)
    public ResponseEntity<String> limitReachedHandler(OneTimeTransactionLimitReachedException ex) {
        return ResponseEntity.status(
                HttpStatus.BAD_REQUEST
        ).body(ex.getMessage());
    }

}
