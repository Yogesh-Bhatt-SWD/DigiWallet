package com.digipay.digitalwallet.repository;

import com.digipay.digitalwallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
