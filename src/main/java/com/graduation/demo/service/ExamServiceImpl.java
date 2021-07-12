package com.graduation.demo.service;

import com.graduation.demo.Dao.AnswerRepository;
import com.graduation.demo.Dao.ExamRepository;
import com.graduation.demo.Dao.NotificationsRepository;
import com.graduation.demo.Model.Answer;
import com.graduation.demo.Model.Exam;
import com.graduation.demo.Model.Notifications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository repository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    NotificationsRepository notificationsRepository;
    @Override
    public Exam createExam(Exam exam) {
        log.info("calling Create_Exam service with Object " + exam);
        Exam existingExam = repository.save(exam);
        if (existingExam == null)
            log.warn("Create Exam is null");
        else {
            log.info("Create Exam response " + existingExam);
            Notifications notifications = new Notifications();
            notifications.setDate(exam.getExam_time_from().toString());
            notifications.setCourseId(exam.getCourse().getId());
            notifications.setRead(false);
            StringBuilder builder = new StringBuilder();
            builder.append("Doctor ");
            builder.append(exam.getDoctor_name());
            builder.append(" has Created Exam : ");
            builder.append(exam.getExam_title());
            builder.append(" for Course : ");
            builder.append(exam.getCourse_name());
            builder.append(" on Date : ");
            builder.append(exam.getExam_time_from().toString());
            builder.append(" You Can Check from Your Next Exam Tap");

            notifications.setMessage(builder.toString());

            notificationsRepository.save(notifications);
        }
            return existingExam;
    }

    @Override
    public Exam updateExam(Exam exam) {
        log.info("calling  update_exam service " + exam);
        Exam existingExam = repository.findById(exam.getId()).orElse(null);
        if (existingExam == null)
            log.warn("Update_Exam is null");
        else {
            existingExam.setExam_date(exam.getExam_date());
            existingExam.setExam_over(exam.getExam_over());
            existingExam.setDoctor_name(exam.getDoctor_name());
            existingExam.setExam_time_to(exam.getExam_time_to());
            existingExam.setExam_time_from(exam.getExam_time_from());
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

    @Override
    public List<Exam> getAllExams(Long id) {
        log.info("calling  getAllExams service " + id);
      List<Exam> existingExam = repository.getAllExams(id);
        for (Exam exam:existingExam  ) {
            List<Answer> answerList=answerRepository.getAllByStudentAndExamId(id,exam.getId());
            if (answerList!=null && answerList.size()>0){
                existingExam.remove(exam);
            }
        }
        if (existingExam == null)
            log.warn("get All Exams is null");
        else
            log.info("get All Exams " + existingExam.size());
        return existingExam;
    }

    @Override
    public List<Exam> getAllNextExams(Long id) {
        log.info("calling  getAllExams service " + id);
        List<Exam> existingExam = repository.getAllNextExams(id);
        if (existingExam == null)
            log.warn("get All Exams is null");
        else
            log.info("get All Exams " + existingExam.size());
        return existingExam;
    }
}
