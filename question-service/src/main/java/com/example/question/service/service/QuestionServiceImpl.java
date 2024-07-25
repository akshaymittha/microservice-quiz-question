package com.example.question.service.service;

import com.example.question.service.entity.Question;
import com.example.question.service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository repository;

    @Override
    public Question create(Question question) {
        return repository.save(question);
    }

    @Override
    public List<Question> get() {
        return repository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Question no found with: " + id));
    }

    @Override
    public List<Question> getQuestionByQuiz(Long quizId) {
        return repository.findByQuizId(quizId);
    }
}
