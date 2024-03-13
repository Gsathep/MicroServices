package com.question.service;

import com.question.domain.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService
{
    Question save(Question question);

    List<Question> getAll();

    Optional<Question> getById(Long id);

    List<Question> findByQuizId(Long quizId);
}
