package poly.edu.contronller;




import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.entity.Staff2;



@Controller
@RequestMapping("/staff")
public class StaffController2 {

    // Hiển thị form nhập
    @GetMapping("/create/form")
    public String createForm(Model model, @ModelAttribute("staff") Staff2 staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "staff-create"; // resources/templates/staff-create.html
    }

    // Xử lý form + validation
    @PostMapping("/create/save")
    public String createSave(Model model,
                             @RequestPart("photo_file") MultipartFile photoFile,
                             @Valid @ModelAttribute("staff") Staff2 staff,

                             Errors errors) {

        // Nếu có upload file ảnh
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }

        return "staff-validate"; // resources/templates/staff-validate.html
    }
}

