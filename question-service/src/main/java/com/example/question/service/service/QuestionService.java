package com.example.question.service.service;

import com.example.question.service.entity.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    List<Question> get();

    Question getOne(Long id);

    List<Question> getQuestionByQuiz(Long quizId);
}
