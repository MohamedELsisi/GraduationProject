package com.graduation.demo.Dao;

import com.graduation.demo.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Query(value = "SELECT ex.* FROM exam ex INNER JOIN course co ON ex.course_id = co.id INNER JOIN level_and_dep le ON co.department=le.department_id AND co.level=le.level_id INNER JOIN student st ON le.id=st.levai_dep_id WHERE st.id= :student_id", nativeQuery = true)
    List<Exam> getAllExams(@Param("student_id") Long id);
}
