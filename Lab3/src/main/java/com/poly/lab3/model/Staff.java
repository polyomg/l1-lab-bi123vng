package poly.edu.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Staff {
    private String id;

    @Builder.Default
    private String fullName = "Nguyễn Văn User";

    @Builder.Default
    private String photo = "photo.jpg";

    @Builder.Default
    private Boolean gender = true;

    @Builder.Default
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday = new Date();

    @Builder.Default
    private Double salary = 12345.6789;

    @Builder.Default
    private Integer level = 0;
}
