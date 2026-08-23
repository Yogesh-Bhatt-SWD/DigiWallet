package com.digipay.digitalwallet.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class UserTransferMoneyResponse {
    private Long transactionId;

    private String senderName;

    private String receiverName;

    private BigDecimal amount;

    private LocalDateTime transferredAt;

    private BigDecimal remainingBalance;
}
