package com.graduation.demo.service;

import com.graduation.demo.Model.Exam;

public interface ExamService {
    public Exam createExam(Exam exam);
    public Exam updateExam(Exam exam);
    public Exam findExam(String name);

}
