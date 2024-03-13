package com.quiz.web;

import com.quiz.domain.Quiz;
import com.quiz.service.QuizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class QuizResource
{
    @Autowired
    private QuizeService quizeService;
    @PostMapping("/save")
    public ResponseEntity<Quiz>save(@RequestBody  Quiz quiz)
    {
        Quiz quiz1=quizeService.save(quiz);
        return ResponseEntity.ok(quiz1);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Quiz>>getall()
    {
       List <Quiz> quiz= quizeService.getAll();
        return new  ResponseEntity<>(quiz,HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Quiz>getById(@PathVariable Long  id)
    {
        Optional<Quiz> quiz=quizeService.getById(id);
        if (quiz.isPresent())
        {
            return new ResponseEntity<>(quiz.get(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
