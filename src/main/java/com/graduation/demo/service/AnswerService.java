package com.graduation.demo.service;

import com.graduation.demo.Model.Answer;

public interface AnswerService {
    public Answer createAnswer(Answer answer);
    public Answer UpdateAnswer(Answer answer);
    public boolean deleteAnswer(Long id);

}
