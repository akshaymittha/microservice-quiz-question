package com.example.quiz.service.service;

import com.example.quiz.service.entity.Quiz;
import com.example.quiz.service.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository repository;

    @Autowired
    private QuestionClient client;

    @Override
    public Quiz add(Quiz quiz) {
        return repository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> all = repository.findAll();
        return all.stream().map(quiz -> {
            quiz.setQuestion(client.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = repository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found with : " + id));
        quiz.setQuestion(client.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
