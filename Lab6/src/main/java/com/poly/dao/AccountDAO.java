package com.example.j5shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.j5shop.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
}
