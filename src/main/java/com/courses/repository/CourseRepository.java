package com.courses.repository;

import com.courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository added
public interface CourseRepository extends JpaRepository<Course,Integer>
{
}
