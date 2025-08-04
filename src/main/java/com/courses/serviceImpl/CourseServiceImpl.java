package com.courses.serviceImpl;

import com.courses.entity.Course;
import com.courses.repository.CourseRepository;
import com.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    //inject repository in this
    @Autowired
    private CourseRepository repository;

    @Override
    public String saveCourse(Course course) {
        System.err.println(course);
        repository.save(course);
        return "Course saved";
    }

    @Override
    public List<Course> getAllCourse() {
        List<Course> courseList = repository.findAll();
        return courseList;
    }

    @Override
    public Course getCourseById(int id) {
        Course courseById = repository.findById(id).orElseThrow(()-> new NullPointerException("Data not found"+id));
        return courseById;
    }
}
