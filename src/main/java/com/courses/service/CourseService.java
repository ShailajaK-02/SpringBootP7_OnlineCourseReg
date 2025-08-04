package com.courses.service;

import com.courses.entity.Course;

import java.util.List;

public interface CourseService
{
    String saveCourse(Course course);

    List<Course> getAllCourse();

    Course getCourseById(int id);
}
