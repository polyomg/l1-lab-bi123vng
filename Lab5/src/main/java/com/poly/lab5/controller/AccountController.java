package com.example.lab5.controller;

import com.example.lab5.service.CookieService;
import com.example.lab5.service.ParamService;
import com.example.lab5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String login1() {
        return "/account/login";
    }

    @PostMapping("/account/login")
    public String login2() {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        if (un.equals("poly") && pw.equals("123")) {
            // Lưu username vào session
            sessionService.set("username", un);

            // Ghi nhớ tài khoản
            if (rm) {
                cookieService.add("user", un, 24 * 10); // 10 ngày
            } else {
                cookieService.remove("user");
            }
            return "redirect:/item/index";
        }
        return "/account/login";
    }
}
