package com.graduation.demo.Dao;

import com.graduation.demo.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
     Course findByName(String name);

     @Query(value = "SELECT * FROM course WHERE doctor_id=?1", nativeQuery = true)
     List<Course> findByDoctorId(int doctorId);
     @Query(value = "SELECT co.* FROM course co INNER JOIN level_and_dep le ON co.department_id=le.department_id AND co.level_id=le.level_id INNER JOIN student st ON st.level_dep_id=le.id WHERE st.id=?1", nativeQuery = true)
     List<Course> findAllCoursesByStudentId(int studentId);
}
