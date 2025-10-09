package poly.edu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParamController {

    @RequestMapping("/form")
    public String form() {
        return "param/form";
    }

    @RequestMapping("/param/save/{x}")
    public String save(
            @PathVariable("x") String x,        // ?1
            @RequestParam("y") String y,        // ?2
            Model model) {

        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "param/form";
    }
}
