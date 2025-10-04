package poly.edu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staff2 {
    private String id;
    private String fullname;
    private String photo;
    private double salary;
    private int level;
}
