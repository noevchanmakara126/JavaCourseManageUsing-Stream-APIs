package service;

import exception.CourseNotFoundException;
import exception.NoLetterInputException;
import exception.NoNumInputException;
import mode.Course;

import java.util.List;

public interface CourseService {


    void addCourse() throws  NoNumInputException;
    void allCourse();

    Course getCoursesID(Integer id) throws CourseNotFoundException, NoLetterInputException;
    Course getCourseTitle(String title)throws CourseNotFoundException; ;
    int removeCourse(Integer id) throws CourseNotFoundException;
}
