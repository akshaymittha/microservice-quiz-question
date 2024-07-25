package com.example.question.service.controller;

import com.example.question.service.entity.Question;
import com.example.question.service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @PostMapping
    public Question create(@RequestBody Question question) {
        return service.create(question);
    }

    @GetMapping
    public List<Question> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public Question getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionByQuiz(@PathVariable Long quizId) {
        return service.getQuestionByQuiz(quizId);
    }
}
