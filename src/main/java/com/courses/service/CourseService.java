package com.courses.service;

import com.courses.entity.Course;
import org.aspectj.weaver.ast.Literal;

import java.util.List;
import java.util.Timer;

public interface CourseService
{
    //save method added
    String saveCourse(Course course);

    //getdata method
    List<Course> getAllCourse();

    //getById method added
    Course getCourseById(int id);

    //delete method added
    String deleteCourse(int id);

    //update method added
    Course updateCourse(int id, Course newCourse);

    //save list
    String saveList(List<Course> courseList);
}
