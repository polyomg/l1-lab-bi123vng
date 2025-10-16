package com.example.j5shop.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.j5shop.dao.ProductDAO;
import com.example.j5shop.entity.Product;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    // GỘP BÀI 4 VÀO BÀI 3
    @RequestMapping("/product/sort")
    public String sortAndPaginate(Model model,
                                  @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5); // 5 sp mỗi trang
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
        return "product/sort"; // vẫn là trang sort.html
    }
}
