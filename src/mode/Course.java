package mode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Integer courseId;
    private String  courseTitle;
    private String [] instructorName;
    private String [] requirement;
    private LocalDate date = LocalDate.now(); ;


}
