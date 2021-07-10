package com.graduation.demo.Dao;

import com.graduation.demo.Model.Answer;
import com.graduation.demo.Model.Student;
import com.graduation.demo.dto.DoctorReportForCourseAndExam;
import com.graduation.demo.dto.StudentAndExamForCourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface StudentRepository extends JpaRepository<Student,Long> {
   Student findByName(String name);
   Student findByEmail(String email);


   @Query(value = "SELECT st.* , ex.id as exam_id FROM student st INNER JOIN level_and_dep le ON le.id=st.level_dep_id INNER JOIN course co on co.department_id=le.department_id AND co.level_id=le.level_id INNER Join  exam ex on ex.course_id =co.id where co.id= :course", nativeQuery = true)
   List<StudentAndExamForCourseDto> getAllStudentAtCourseId(@Param("course") long course_id );

}
