package com.question.service.Implimentation;

import com.question.Repo.QuestionRepo;
import com.question.domain.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionIml implements QuestionService
{
    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Question save(Question question) {
         return questionRepo.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepo.findAll();
    }

    @Override
    public Optional<Question> getById(Long id) {
        Optional<Question> question=questionRepo.findById(id);
        return question;
    }

    @Override
    public List<Question> findByQuizId(Long quizId) {
        return questionRepo.findByQuizId(quizId);

    }
}
