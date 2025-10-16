package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RectangleController {

    @Autowired
    private HttpServletRequest request;

    // Hiển thị form
    @GetMapping("/rectangle/form")
    public String form() {
        return "rectangle";
    }

    // Xử lý tính toán
    @PostMapping("/rectangle/calc")
    public String calc(Model model) {
        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));

        double area = length * width;
        double perimeter = 2 * (length + width);

        String result = "Diện tích = " + area + " ; Chu vi = " + perimeter;
        model.addAttribute("result", result);

        return "rectangle";
    }
}
