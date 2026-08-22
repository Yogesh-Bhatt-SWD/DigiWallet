package com.digipay.digitalwallet.globalexception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserNotFoundException> userHandler(UserNotFoundException ex ) {
        return ResponseEntity.status(
                HttpStatus.NOT_FOUND
        ).body(ex);
    }

    public ResponseEntity<AccountNotFoundException> AccountHandler(AccountNotFoundException ex) {
        return ResponseEntity.status(
                HttpStatus.NOT_FOUND
        ).body(ex);
    }
}
