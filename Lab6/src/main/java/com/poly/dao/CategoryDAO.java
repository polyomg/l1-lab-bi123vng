package com.example.j5shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.j5shop.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {
}