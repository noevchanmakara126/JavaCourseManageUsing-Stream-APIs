package service;

import exception.CourseNotFoundException;
import exception.NoLetterInputException;
import exception.NoNumInputException;
import mode.Course;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import repository.CourseRepository;
import java.time.LocalDate;
import java.util.*;

public class CourseServiceImp implements CourseService {


    @Override
    public void addCourse() {
        CourseRepository.addCourse();
    }

    @Override
    public void allCourse() {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i, 30, 30);
        }
        if (!CourseRepository.courseList().isEmpty()) {
            table.addCell("Course ID ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Course Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Instructor Name ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Course Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Start Date ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            for (Course course : CourseRepository.courseList()) {
                table.addCell(String.valueOf(course.getCourseId()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course.getCourseTitle(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getInstructorName()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getRequirement()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(course.getDate()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());
        } else {
            System.out.println("[+] គ្មានវគ្គសិក្សា");
        }

    }

    @Override
    public Course getCoursesID(Integer id) throws CourseNotFoundException, NoLetterInputException {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i, 30, 30);
        }
        var course = CourseRepository.courseList().stream().filter(course1 -> course1.getCourseId().equals(id)).toList();
        if (course.isEmpty()) {
            throw new CourseNotFoundException();
        }
        else {
            table.addCell("Course ID ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Course Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Instructor Name ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Course Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Start Date ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            for (Course course1 : course) {
                table.addCell(String.valueOf(course1.getCourseId()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course1.getCourseTitle(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course1.getInstructorName()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course1.getRequirement()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(course1.getDate()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());
        }


        return null;
    }

    @Override
    public Course getCourseTitle(String title) throws CourseNotFoundException{
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i, 30, 30);
        }

        var course = CourseRepository.courseList().stream().filter(course1 -> course1.getCourseTitle().toLowerCase().contains(title)).toList();

        if (course.isEmpty()) {
            throw new CourseNotFoundException();
        } else {
            table.addCell("Course ID ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Course Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Instructor Name ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Course Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Start Date ", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            for (Course course1 : course) {
                table.addCell(String.valueOf(course1.getCourseId()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course1.getCourseTitle(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course1.getInstructorName()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course1.getRequirement()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(course1.getDate()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());

        }


        return null;
    }

    @Override
    public int removeCourse( Integer id ) throws CourseNotFoundException{
       List<Course> courseList = CourseRepository.courseList();
       List<Course> removeCourse = courseList.stream().filter(course -> course.getCourseId().equals(id)).toList();
       if (courseList.removeAll(removeCourse)){
           System.out.println("-----------លុបបានដោយជោគជ័យ------------");
       }
       if(!removeCourse.isEmpty()&&courseList.equals(id)){
           System.out.println("------វគ្គសិក្សាដែលមានលេខសម្គាល់ ["+id+"]មិនអាចលុបបាន------");
       }
       else {

           throw new CourseNotFoundException();
       }

        return 0;
    }
}

