package com.digipay.digitalwallet.repository;

import com.digipay.digitalwallet.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Long> {
}
