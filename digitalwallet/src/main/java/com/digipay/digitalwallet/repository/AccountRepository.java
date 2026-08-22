package com.digipay.digitalwallet.repository;

import com.digipay.digitalwallet.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
