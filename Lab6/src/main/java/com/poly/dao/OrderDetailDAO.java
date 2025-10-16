package com.example.j5shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.j5shop.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
}
