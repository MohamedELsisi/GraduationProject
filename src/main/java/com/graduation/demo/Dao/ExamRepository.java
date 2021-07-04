package com.graduation.demo.Dao;

import com.graduation.demo.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Query(value = "Select  exam.* \n" +
            "From exam  join student_and_course\n" +
            "on  exam.course_id = student_and_course.course_id and  student_and_course.student_id= :student_id", nativeQuery = true)
    Set<Exam> getAllExams(@Param("student_id") Long id);
}
