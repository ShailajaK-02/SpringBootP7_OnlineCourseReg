package com.courses.repository;

import com.courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository added
//Jpa is an interface
public interface CourseRepository extends JpaRepository<Course,Integer>
{
}
