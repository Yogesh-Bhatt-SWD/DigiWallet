package com.digipay.digitalwallet.service;

import com.digipay.digitalwallet.dto.UserAccountResponse;
import com.digipay.digitalwallet.entity.Account;
import com.digipay.digitalwallet.entity.User;
import com.digipay.digitalwallet.enums.AccountStatus;
import com.digipay.digitalwallet.globalexception.UserNotFoundException;
import com.digipay.digitalwallet.repository.AccountRepository;
import com.digipay.digitalwallet.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    private UserRepository userRepository;

    public AccountService(AccountRepository accountRepository,UserRepository userRepository) {
        this.accountRepository=accountRepository;
        this.userRepository=userRepository;
    }
    public UserAccountResponse createAccount(Account account, Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("student with this id "+id +" not found")
        );
        account.setStatus(AccountStatus.ACTIVE);
        account.setUser(existingUser);
        Account resp = accountRepository.save(account);

        return mapToDto(resp,existingUser);
    }
    private UserAccountResponse mapToDto(Account resp,User existingUser) {
        UserAccountResponse response = new UserAccountResponse();

        response.setAccountId(resp.getId());
        response.setUsername(existingUser.getName());
        response.setEmail(existingUser.getEmail());
        response.setPhoneNo(existingUser.getPhoneNo());
        response.setBalance(resp.getBalance());
        response.setStatus(resp.getStatus());
        return response;
    }
}
