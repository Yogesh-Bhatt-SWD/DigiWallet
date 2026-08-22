package com.digipay.digitalwallet.controller;

import com.digipay.digitalwallet.dto.UserAccountResponse;
import com.digipay.digitalwallet.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.digipay.digitalwallet.entity.Account;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService=accountService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<UserAccountResponse> createAccount(@RequestBody Account account, @PathVariable Long id) {
        UserAccountResponse response = accountService.createAccount(account,id);
        return ResponseEntity.status(
                HttpStatus.CREATED
        ).body(response);
    }
}
