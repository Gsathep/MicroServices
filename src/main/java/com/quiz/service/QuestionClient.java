package com.quiz.service;

import com.quiz.domain.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
//@FeignClient(url = "http://localhost:8082", value = "Question-client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {
    @GetMapping("/api/question/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable Long quizId);
}
