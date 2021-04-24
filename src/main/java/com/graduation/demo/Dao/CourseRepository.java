package com.graduation.demo.Dao;

import com.graduation.demo.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
     Course findByName(String name);
}
