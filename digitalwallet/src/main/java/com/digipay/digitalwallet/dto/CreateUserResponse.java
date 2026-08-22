package com.digipay.digitalwallet.dto;

import com.digipay.digitalwallet.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponse {
    private Long id;

    private String name;

    private int age;

    private String email;

    private String phoneNo;

    private UserStatus status;

}
