package com.digipay.digitalwallet.dto;

import com.digipay.digitalwallet.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class UserAccountResponse {
    private Long accountId;

    private String username;

    private String email;

    private String phoneNo;

    private BigDecimal balance;

    private AccountStatus status;
}
