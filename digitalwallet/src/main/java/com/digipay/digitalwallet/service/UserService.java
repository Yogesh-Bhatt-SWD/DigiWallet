package com.digipay.digitalwallet.service;

import com.digipay.digitalwallet.dto.*;
import com.digipay.digitalwallet.entity.Account;
import com.digipay.digitalwallet.entity.User;
import com.digipay.digitalwallet.enums.AccountStatus;
import com.digipay.digitalwallet.enums.UserStatus;
import com.digipay.digitalwallet.globalexception.*;
import com.digipay.digitalwallet.repository.AccountRepository;
import com.digipay.digitalwallet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class UserService {

    private final AccountRepository accountRepository;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository=userRepository;
        this.accountRepository = accountRepository;
    }
    public CreateUserResponse createUser(User user){
        user.setStatus(UserStatus.ACTIVE);
        User res =  userRepository.save(user);
        return mapToDto(res);
    }

    public CheckBalanceResponse checkBalance(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user with this id "+id+" not found"));
        Account account = user.getAccount();
        if(account==null) {
            throw new AccountNotFoundException("Account Not Found");
        }
        BigDecimal balance = account.getBalance();
        CheckBalanceResponse response = new CheckBalanceResponse();
        response.setBalance(balance);
        return response;
    }
    public UserDepositResponse depositAmount(UserDepositRequest deposit,Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user with this id "+id+" not found"));
        Account account = user.getAccount();
        if(account==null) {
            throw new AccountNotFoundException("Account Not Found");
        }
        if(account.getStatus()== AccountStatus.BLOCKED||account.getStatus()==AccountStatus.CLOSED) {
            throw new InvalidAccountStatusException("Can't do payment. Account is blocked or closed");
        }
        BigDecimal amount = deposit.getAmount();
        if(amount==null) {
            throw new IllegalArgumentException("Amount cant be null");
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        BigDecimal newBalance = account.getBalance().add(amount);
        account.setBalance(newBalance);
        Account res = accountRepository.save(account);
        return mapToDto(res,amount);
    }

    private CreateUserResponse mapToDto(User res) {
        CreateUserResponse resp = new CreateUserResponse();

        resp.setId(res.getId());
        resp.setName(res.getName());
        resp.setEmail(res.getEmail());
        resp.setAge(res.getAge());
        resp.setStatus(res.getStatus());
        resp.setPhoneNo(res.getPhoneNo());

        return resp;
    }
    private UserDepositResponse mapToDto(Account account,BigDecimal amount) {
        UserDepositResponse response = new UserDepositResponse();
        response.setAccountBalance(account.getBalance());
        response.setDepositedAmount(amount);
        response.setDepositedAt(LocalDateTime.now());
        return response;
    }

    public UserTransferMoneyResponse transferMoney(UserTransferMoneyRequest transferMoneyRequest, Long userId) {
        User sender = userRepository.findById(transferMoneyRequest.getFromUserId()).orElseThrow(
                () -> new UserNotFoundException("User with this id " + transferMoneyRequest.getFromUserId() + " not found ")
        );
        User receiver = userRepository.findById(transferMoneyRequest.getToUserId()).orElseThrow(
                () -> new UserNotFoundException("User with this id " + transferMoneyRequest.getToUserId() + " not found ")
        );

        Account senderAccount = sender.getAccount();
        Account receiverAccount = receiver.getAccount();

        if (senderAccount == null || receiverAccount == null) {
            throw new AccountNotFoundException("Account Not Found ");
        }
        BigDecimal senderBalance = senderAccount.getBalance();
        BigDecimal sendingAmount = transferMoneyRequest.getAmount();

        if (sendingAmount.compareTo(senderBalance) > 0) {
            throw new InsufficientBankBalanceException(
                    "Insufficient balance"
            );
        }
        if (sendingAmount.compareTo(new BigDecimal("25000")) > 0) {
            throw new OneTimeTransactionLimitReachedException("Limit reached: one-time transaction can't be more than 25000 rupees");
        }


        return null;
    }
