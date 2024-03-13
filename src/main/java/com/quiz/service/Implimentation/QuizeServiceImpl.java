package com.quiz.service.Implimentation;

import com.quiz.Repo.QuizRepo;
import com.quiz.domain.Quiz;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizeServiceImpl implements QuizeService
{
    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuestionClient questionClient;

    public QuizeServiceImpl(QuizRepo quizRepo, QuestionClient questionClient) {
        this.quizRepo = quizRepo;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz save(Quiz quiz) {
        return  quizRepo.save(quiz);

    }

    @Override
    public List<Quiz> getAll() {
       List <Quiz>quizzes=quizRepo.findAll();
       List<Quiz>quizzes1=quizzes.stream().map(quiz -> {
           quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
           return quiz;
       }).collect(Collectors.toList());
       return quizzes1;
    }

    @Override
    public Optional<Quiz> getById(Long id) {
        Quiz quiz= quizRepo.findById(id).orElseThrow(()-> new RuntimeException("quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return Optional.of(quiz);
    }
}
