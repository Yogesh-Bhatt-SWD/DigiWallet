package com.digipay.digitalwallet.service;

import com.digipay.digitalwallet.entity.Account;
import com.digipay.digitalwallet.entity.TransactionHistory;
import com.digipay.digitalwallet.repository.TransactionHistoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionHistoryService {
    private TransactionHistoryRepository transactionHistoryRepository;
    public TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository) {
        this.transactionHistoryRepository=transactionHistoryRepository;
    }
    public TransactionHistory addTransaction(Account senderAccount, Account receiverAccount, BigDecimal amount) {
        TransactionHistory transaction = new TransactionHistory();
        transaction.setFromAccount(senderAccount);
        transaction.setToAccount(receiverAccount);
        transaction.setAmount(amount);
        transaction.setTransferredAt(LocalDateTime.now());
        return transactionHistoryRepository.save(transaction);
    }
}
