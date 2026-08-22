package com.digipay.digitalwallet.entity;

import com.digipay.digitalwallet.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "fromAccount")
    private List<TransactionHistory> sentTransaction;

    @OneToMany(mappedBy = "toAccount")
    private List<TransactionHistory> receivedTransaction;

}
