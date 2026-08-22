package com.digipay.digitalwallet.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserDepositRequest {
    private BigDecimal amount;
}
