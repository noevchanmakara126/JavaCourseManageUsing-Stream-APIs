import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import exception.CourseNotFoundException;
import exception.NoLetterInputException;
import exception.NoNumInputException;
import service.*;

import static view.View.view;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf(
                "           ██     ██ ███████ ██       ██████  ██████  ███    ███ ███████     ████████  ██████       ██████ ███████ ████████  █████  ██████  \n" +
                        "           ██     ██ ██      ██      ██      ██    ██ ████  ████ ██             ██    ██    ██     ██      ██         ██    ██   ██ ██   ██ \n" +
                        "           ██  █  ██ █████   ██      ██      ██    ██ ██ ████ ██ █████          ██    ██    ██     ██      ███████    ██    ███████ ██   ██ \n" +
                        "           ██ ███ ██ ██      ██      ██      ██    ██ ██  ██  ██ ██             ██    ██    ██     ██           ██    ██    ██   ██ ██   ██ \n" +
                        "           ███ ███   ███████ ███████  ██████  ██████  ██      ██ ███████        ██     ██████       ██████ ███████    ██    ██   ██ ██████  \n" +
                        "                                                                                                                                      \n");

        do {
            view();
            try {
                System.out.printf("សូមបញ្ចូលជម្រើសរបស់អ្នក : ");
                CourseServiceImp serviceImp = new CourseServiceImp();
                Integer ch = new Scanner(System.in).nextInt();
                switch (ch) {

                    case 1: {
                        System.out.println("1.==========បន្ថៃមវគ្គសិក្សាថ្មី==========");
                        serviceImp.addCourse();
                        System.out.println("===================================");

                        break;
                    }
                    case 2: {
                        System.out.println("2.=========វគ្គសិក្សាដែលមានទាំងអស់==========");
                        serviceImp.allCourse();


                        break;
                    }
                    case 3: {
                        try {
                            System.out.println("3.==========ស្វែងរកវគ្គសិក្សាដោយលេខសម្គាល់==========");
                            System.out.printf("សូមបញ្ញូលលេខសម្គាល់ ID : ");
                            Integer id = new Scanner(System.in).nextInt();
                            serviceImp.getCoursesID(id);

                        } catch (CourseNotFoundException courseNotFoundException) {
                            System.out.println(courseNotFoundException.getMessage());

                        } catch (InputMismatchException e) {
                            System.out.println("សូមបញ្ចូលតែជាលេខ");
                        } catch (NoLetterInputException noLetterInputException) {
                            System.out.println(noLetterInputException.getMessage());
                        }
                        break;
                    }
                    case 4: {
                        try {
                            System.out.println("4.==========ស្វែងរកវគ្គសិក្សាដោយចំណងជើង==========");
                            System.out.printf("សូមបញ្ចូលឈ្មោះនៃវគ្គសិក្សា : ");
                            String title = new Scanner(System.in).nextLine();
                            serviceImp.getCourseTitle(title);


                        } catch (CourseNotFoundException courseNotFoundException) {
                            System.out.println(courseNotFoundException.getMessage());

                        }
                        break;
                    }
                    case 5: {
                        try {
                            System.out.println("5.==========លុបវគ្គសិក្សាដោយលេខសម្គាល់==========");

                            System.out.printf("សូមបញ្ចូលលេខសម្គាល់វគ្គសិក្សា ID : ");
                            Integer id = new Scanner(System.in).nextInt();
                            serviceImp.removeCourse(id);
                        } catch (CourseNotFoundException courseNotFoundException) {
                            System.out.println(courseNotFoundException.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("សូមបញ្ចូលតែជាលេខ");
                        }
                        break;
                    }

                    case 6: {
                        System.out.println("6.==========ចាកចេញពីកម្មវិធី==========");
                        System.out.printf("សូមអរគុណ!! ជូនពរជួបតែសំណាងល្អនិងសុខភាពល្អ");
                        System.exit(0);

                    }
                }

            }catch (InputMismatchException e) {
                System.out.println("-----------សូមបញ្ចូលតែជាលេខ----------");}



        } while (true);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}