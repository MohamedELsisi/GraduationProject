package com.graduation.demo.service;

import com.graduation.demo.Model.Answer;
import com.graduation.demo.dto.StudentAnswerForCourseDTO;

import java.util.List;

public interface AnswerService {
    public Answer createAnswer(Answer answer);
    public Answer UpdateAnswer(Answer answer);
    public boolean deleteAnswer(Long id);
    public List<Answer>getAllStudentAnswers(Long id);

    public List<Answer> getAllByExamAndStudentId(Long stud_id,Long Exam_id );
    public StudentAnswerForCourseDTO getAllByStudentAndCourseId(Long stud_id, Long course_id );





}
