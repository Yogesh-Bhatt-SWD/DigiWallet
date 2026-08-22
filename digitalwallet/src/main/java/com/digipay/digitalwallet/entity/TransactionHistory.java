package com.digipay.digitalwallet.entity;

import com.digipay.digitalwallet.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="from_account_id")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name="to_account_id")
    private Account toAccount;

    private BigDecimal amount;

    private LocalDateTime transferredAt;
}
