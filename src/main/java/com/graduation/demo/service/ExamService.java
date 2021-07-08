package com.graduation.demo.service;

import com.graduation.demo.Model.Exam;

import java.util.List;
import java.util.Set;

public interface ExamService {
    public Exam createExam(Exam exam);
    public Exam updateExam(Exam exam);
    public Exam findExam(String name);

    public List<Exam> getAllExams(Long id);
    public List<Exam> getAllNextExams(Long id);

}
