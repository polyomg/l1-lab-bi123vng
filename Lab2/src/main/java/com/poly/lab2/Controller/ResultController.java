package poly.edu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class    ResultController {

    @RequestMapping("/a")
    public String m1() {
        return "a";   // gọi view a.html
    }

    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("me   ssage", "I come from b");
        return "a";   // ?1 => view a.html
    }

    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a";   // ?2 => redirect sang /a
    }

    @ResponseBody
    @RequestMapping("/d")
    public String m4() {
        return "I come from d"; // ?3 => trả text trực tiếp
    }
}
