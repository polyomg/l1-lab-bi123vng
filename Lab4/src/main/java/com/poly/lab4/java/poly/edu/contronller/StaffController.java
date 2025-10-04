package poly.edu.contronller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.entity.Staff;

@Controller
public class StaffController {

    @RequestMapping("/staff/create/form")
    public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "/staff-create"; // staff-create.html trong thư mục /templates/demo/
    }

    @RequestMapping("/staff/create/save")
    public String createSave(Model model,
                             @ModelAttribute("staff") Staff staff,
                             @RequestPart("photo_file") MultipartFile photoFile) {
        // Nếu người dùng upload file ảnh
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        model.addAttribute("message", "Xin chào " + staff.getFullname() + "!");
        return "/staff-create";
    }
}
