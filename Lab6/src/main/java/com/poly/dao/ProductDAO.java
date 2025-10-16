package com.example.j5shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.j5shop.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
}
