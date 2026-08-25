package com.digipay.digitalwallet.dto;

import com.digipay.digitalwallet.entity.TransactionHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionHistoryResponse {
    private Long accountId;

    private String userName;

    private List<TransactionHistory>  transaction;
}
