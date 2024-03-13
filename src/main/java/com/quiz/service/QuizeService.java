package com.quiz.service;

import com.quiz.domain.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizeService {
    Quiz save(Quiz quiz);

    List<Quiz> getAll();

    Optional<Quiz> getById(Long id);
}
