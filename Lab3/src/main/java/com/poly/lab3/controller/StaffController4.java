package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.model.Staff2;

import java.util.List;

@Controller
public class StaffController4 {

    @RequestMapping("/staff/list4")
    public String list(Model model) {
        List<Staff2> list = List.of(
                Staff2.builder().id("user1@gmail.com").fullname("Nguyễn Văn User1").build(),
                Staff2.builder().id("user2@gmail.com").fullname("Nguyễn Văn User2").build(),
                Staff2.builder().id("user3@gmail.com").fullname("Nguyễn Văn User3").build(),
                Staff2.builder().id("user4@gmail.com").fullname("Nguyễn Văn User4").build(),
                Staff2.builder().id("user5@gmail.com").fullname("Nguyễn Văn User5").build(),
                Staff2.builder().id("user6@gmail.com").fullname("Nguyễn Văn User6").build()
        );

        model.addAttribute("list", list);
        return "demo/list-status"; // file list-status.html
    }
}
