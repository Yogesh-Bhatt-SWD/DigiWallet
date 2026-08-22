package com.digipay.digitalwallet.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDepositResponse {
    private BigDecimal depositedAmount;

    private BigDecimal accountBalance;

    private LocalDateTime depositedAt;

}
