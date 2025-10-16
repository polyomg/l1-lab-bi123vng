package com.example.j5shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.j5shop.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {
}
