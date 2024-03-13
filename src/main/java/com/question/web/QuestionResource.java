package com.question.web;

import com.question.domain.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QuestionResource
{
    @Autowired
    private QuestionService questionService;
    @PostMapping("/save")
    public ResponseEntity <Question> save(@RequestBody Question question)
    {
        Question question1=questionService.save(question);
        return  new ResponseEntity<>(question1, HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity <List<Question>> getAll()
    {
        List<Question> question1=questionService.getAll();
        return  new ResponseEntity<>(question1, HttpStatus.OK);

    }
    @GetMapping("/getBy-id/{id}")
    public ResponseEntity <Question> getById(@PathVariable Long id) {
        Optional<Question> question1 = questionService.getById(id);
        if (question1.isPresent()) {
            return new ResponseEntity<>(question1.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

        @GetMapping("/question/quiz/{quizId}")
        public ResponseEntity<List<Question>> getQuestionOfQuiz(@PathVariable Long quizId) {

            List<Question> questions = questionService.findByQuizId(quizId);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        }

    }