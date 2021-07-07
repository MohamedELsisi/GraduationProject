package com.graduation.demo.Dao;

import com.graduation.demo.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
     Course findByName(String name);

     @Query(value = "SELECT * FROM course WHERE doctor_id=?1", nativeQuery = true)
     List<Course> findByDoctorId(int doctorId);
}
