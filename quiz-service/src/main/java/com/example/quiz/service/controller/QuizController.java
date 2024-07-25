package com.example.quiz.service.controller;

import com.example.quiz.service.entity.Quiz;
import com.example.quiz.service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService service;

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return service.add(quiz);
    }

    @GetMapping
    public List<Quiz> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id) {
        return service.get(id);
    }
}
