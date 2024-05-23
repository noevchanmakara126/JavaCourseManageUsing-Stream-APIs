package repository;

import exception.NoNumInputException;
import mode.Course;
import service.CourseService;
import service.CourseServiceImp;

import java.time.LocalDate;
import java.util.*;

public class CourseRepository {

 static List<Course> courses = new ArrayList<>();
 public static void addCourse() {
  CourseService courseService = new CourseServiceImp();
  Random random = new Random();
  try {
   System.out.printf("[+]--- សូមបញ្ចូលឈ្មោះនៃវគ្គសិក្សា --- : ");
   String title = new Scanner(System.in).nextLine();
   for(int i = 0; i < 9; i++) {
    if (title.contains(String.valueOf(i))) {
     throw new NoNumInputException();
    }
   }
   
   System.out.printf("[+]--- សូមបញ្ចូលឈ្មោះនៃវគ្រូបង្រៀន --- : ");
   String[] instructor = new Scanner(System.in).nextLine().trim().split(",");

   for(int i = 0; i < 9; i++) {
    for (String instructorName : instructor) {
     if (instructorName.contains(String.valueOf(i))) {
      throw new NoNumInputException();
     }
    }

   }
   System.out.printf("[+]--- សូមបញ្ចូលការទាមទារនៃវគ្គសិក្សានីមួយៗ --- : ");
   String[] requiement = new Scanner(System.in).nextLine().trim().split(",");
   for(int i = 0; i < 9; i++) {
    for (String re : instructor) {
     if (re.contains(String.valueOf(i))) {
      throw new NoNumInputException();
     }
    }

   }
   LocalDate date = LocalDate.now();
   courses.add(new Course(random.nextInt(10000), title, instructor, requiement, date));
  }catch (NoNumInputException noNumInputException){
   System.out.println(noNumInputException.getMessage());
  }

 }
 public static List<Course> courseList() {
  return courses;
 }


}
