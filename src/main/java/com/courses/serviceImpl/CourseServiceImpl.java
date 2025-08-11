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

    //save implemented
    @Override
    public String saveCourse(Course course) {
        System.err.println(course);
        repository.save(course);
        return "Course saved";
    }

    //getall implemented
    @Override
    public List<Course> getAllCourse() {
        List<Course> courseList = repository.findAll();
        return courseList;
    }

    //getbyid implemented
    @Override
    public Course getCourseById(int id) {
        Course courseById = repository.findById(id).orElseThrow(()-> new NullPointerException("Data not found"+id));
        return courseById;
    }

    //delete implemented
    @Override
    public String deleteCourse(int id) {
        repository.deleteById(id);
        return "Course deleted";
    }

    //update implemented
    @Override
    public Course updateCourse(int id, Course newCourse) {
        Course course = repository.findById(id).orElseThrow(()-> new NullPointerException("Data not found"));
        course.setFeesPaid(newCourse.getFeesPaid());
        Course updateCourse = repository.save(course);
        return updateCourse;
    }

    //savelist implemented
    @Override
    public String saveList(List<Course> courseList) {
        repository.saveAll(courseList);
        return "List saved";
    }
}
