package com.graduation.demo.Dao;

import com.graduation.demo.Model.Answer;
import com.graduation.demo.service.AnswerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {

    @Query(value = "Select * from answer \n" +
            "where answer.student_id= :student_id", nativeQuery = true)
    List<Answer> getAllByStudentId(@Param("student_id") long id );


    @Query(value = "Select * from answer \n" +
            "  where answer.student_id= :Student and answer.exam_id= :exam ", nativeQuery = true)
    List<Answer>getAllByStudentAndExamId(@Param("Student") long id , @Param("exam") long exam_id );

    @Query(value = "SELECT ans.* FROM answer ans INNER JOIN exam ex ON ans.exam_id=ex.id WHERE ex.course_id= :course and ans.student_id= :Student", nativeQuery = true)
    List<Answer>getAllByStudentAndCourseId(@Param("Student") long id , @Param("course") long course_id );

    @Query(value = "SELECT ans.* FROM answer ans INNER JOIN exam ex ON ans.exam_id=ex.id WHERE ex.course_id= :course", nativeQuery = true)
    List<Answer> getAllByCourseId( @Param("course") long course_id );


}
