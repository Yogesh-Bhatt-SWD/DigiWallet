package com.digipay.digitalwallet.controller;

import com.digipay.digitalwallet.dto.*;
import com.digipay.digitalwallet.entity.TransactionHistory;
import com.digipay.digitalwallet.entity.User;
import com.digipay.digitalwallet.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService=userService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody User user) {
        CreateUserResponse res = userService.createUser(user);
        return ResponseEntity.status(
                HttpStatus.CREATED
        ).body(res);
    }
    @GetMapping("/{userId}/account/balance")
    public ResponseEntity<CheckBalanceResponse> checkBalance(@PathVariable Long userId) {
        CheckBalanceResponse response = userService.checkBalance(userId);
        return ResponseEntity.status(
                HttpStatus.OK
        ).body(response);
    }
    @PostMapping("/{userId}/account/deposit")
    public ResponseEntity<UserDepositResponse> deposit(@RequestBody UserDepositRequest deposit,@PathVariable Long userId) {
        UserDepositResponse response = userService.depositAmount(deposit,userId);
        return ResponseEntity.status(
                HttpStatus.OK
        ).body(response);

    }

    @PostMapping("/account/sent-money")
    public ResponseEntity<UserTransferMoneyResponse> transferMoney(@RequestBody UserTransferMoneyRequest transferMoneyRequest) {
        UserTransferMoneyResponse response = userService.transferMoney(transferMoneyRequest);
        return ResponseEntity.status(
                HttpStatus.OK
        ).body(response);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<TransactionHistory>> transactionHistory(@PathVariable Long userId) {
        List<TransactionHistory> list = userService.getTransactionHistory(userId);
    }
}
