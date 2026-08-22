package com.digipay.digitalwallet.entity;

import com.digipay.digitalwallet.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(unique = true)
    private String email;

    @Min(18)
    private int age;

    @Column(unique = true)
    private String phoneNo;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToOne(mappedBy = "user")
    private Account account;


}
