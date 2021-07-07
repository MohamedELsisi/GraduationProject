package com.graduation.demo.Dao;

import com.graduation.demo.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Query(value = " Select exam.* from level_and_dep,student,course,exam where course.id=exam.course_id  and course.department=level_and_dep.department_id and course.level=level_and_dep.level_id and level_and_dep.id =student.levai_dep_id and student.id= :student_id", nativeQuery = true)
    List<Exam> getAllExams(@Param("student_id") Long id);
}
