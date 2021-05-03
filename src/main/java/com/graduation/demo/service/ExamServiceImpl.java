package com.graduation.demo.service;

import com.graduation.demo.Dao.ExamRepository;
import com.graduation.demo.Model.Exam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository repository;

    @Override
    public Exam createExam(Exam exam) {
        log.info("calling Create_Exam service with Object " + exam);
        Exam existingExam = repository.save(exam);
        if (existingExam == null)
            log.warn("Create Exam is null");
        else
            log.info("Create Exam response " + existingExam);
        return existingExam;
    }

    @Override
    public Exam updateExam(Exam exam) {
        log.info("calling  update_exam service " + exam);
        Exam existingExam = repository.findById(exam.getId()).orElse(null);
        if (existingExam == null)
            log.warn("Update_Exam is null");
        else {
            existingExam.setDate(exam.getDate());
            existingExam.setStart_time(exam.getStart_time());
            existingExam.setDoctor_name(exam.getDoctor_name());
            existingExam.setTime(exam.getTime());
            existingExam.setQuestion_num(exam.getQuestion_num());
            existingExam.setCourse_name(exam.getCourse_name());
            repository.save(existingExam);
            log.info("Update_Exam response " + existingExam);
        }
        return existingExam;

    }

    @Override
    public Exam findExam(String name) {
        return null;
    }
}
