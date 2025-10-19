package com.example.j5shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.j5shop.dao.CategoryDAO;
import com.example.j5shop.entity.Category;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    @Autowired
    CategoryDAO dao; // Làm việc với bảng Categories

    // 1️⃣ Trang chính hiển thị danh sách + form
    @RequestMapping("/category/index")
    public String index(Model model) {
        Category item = new Category();
        model.addAttribute("item", item);
        List<Category> items = dao.findAll();
        model.addAttribute("items", items);
        return "category/index";
    }

    // 2️⃣ Edit
    @RequestMapping("/category/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        Category item = dao.findById(id).get();
        model.addAttribute("item", item);
        List<Category> items = dao.findAll();
        model.addAttribute("items", items);
        return "category/index";
    }

    // 3️⃣ Create
    @RequestMapping("/category/create")
    public String create(Category item, RedirectAttributes redirectAttributes) {
        dao.save(item);
        redirectAttributes.addFlashAttribute("message", "Thêm danh mục thành công!");
        return "redirect:/category/index";
    }

    // 4️⃣ Update
    @RequestMapping("/category/update")
    public String update(Category item) {
        dao.save(item);
        return "redirect:/category/edit/" + item.getId();
    }

    // 5️⃣ Delete
    @RequestMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        dao.deleteById(id);
        return "redirect:/category/index";
    }
}
