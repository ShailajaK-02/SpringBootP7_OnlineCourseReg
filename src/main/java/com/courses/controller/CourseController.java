package com.courses.controller;

import com.courses.entity.Course;
import com.courses.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController
{
    //inject service in this
    @Autowired
    private CourseService courseService;

    //add data api
    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        courseService.saveCourse(course);
        return new ResponseEntity<>("Course Added", HttpStatus.CREATED);
    }

    //get all data
    @GetMapping("/getAllData")
    public ResponseEntity<List<Course>> getAllData(){
        List<Course> courseList = courseService.getAllCourse();
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    //get data by id
    @GetMapping("/getDataById/{id}")
    public ResponseEntity<Course> getById(@PathVariable("id") int id) {
        Course courseById = courseService.getCourseById(id);
        return new ResponseEntity<>(courseById, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>("Course deleted",HttpStatus.OK);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<Course> update(@PathVariable("id")int id, @RequestBody Course course){
       Course updatedCourse = courseService.updateCourse(id,course);
       return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
    }

    //list
    @PostMapping("/addList")
    public ResponseEntity<String> addList(@RequestBody List<Course> courseList){
        courseService.saveList(courseList);
        return new ResponseEntity<>("list saved",HttpStatus.OK);
    }
}
