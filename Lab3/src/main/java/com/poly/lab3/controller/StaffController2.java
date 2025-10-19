package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.model.Staff2;

import java.util.List;

@Controller
public class StaffController2 {

    @RequestMapping("/staff/list")
    public String list(Model model) {
        List<Staff2> list = List.of(
                Staff2.builder().id("user1").fullname("Nguyễn Văn User1").photo("avatar.jpg").salary(12345.68).build(),
                Staff2.builder().id("user2").fullname("Nguyễn Văn User2").photo("avatar.jpg").salary(12345.68).build(),
                Staff2.builder().id("user3").fullname("Nguyễn Văn User3").photo("avatar.jpg").salary(12345.68).build(),
                Staff2.builder().id("user4").fullname("Nguyễn Văn User4").photo("avatar.jpg").salary(12345.68).build(),
                Staff2.builder().id("user5").fullname("Nguyễn Văn User5").photo("avatar.jpg").salary(12345.68).build(),
                Staff2.builder().id("user6").fullname("Nguyễn Văn User6").photo("avatar.jpg").salary(12345.68).build()
        );

        model.addAttribute("list", list);
        return "demo/staff-list";  // trỏ tới staff-list.html
    }
}
