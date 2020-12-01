package com.exampl.demo.contollers;

import com.exampl.demo.exceptions.ParameterNotSpecifiedException;
import com.exampl.demo.exceptions.ResourceNotFoundException;
import com.exampl.demo.models.*;
import com.exampl.demo.repositories.AnswerRepository;
import com.exampl.demo.repositories.QuestionRepository;
import com.exampl.demo.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    TestRepository testRepository;

    @GetMapping
    public Page<Question> getAllGroups(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @GetMapping("{questionId}")
    public Question getQuestionById(@PathVariable Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question " + questionId + " not found!"));
    }

    @PostMapping
    public Question createQuestion(@Valid @RequestBody Question question) {
        Question temp = questionRepository.save(question);
        if (temp.getAnswerList() != null)
            temp.getAnswerList().forEach(answer -> answer.setQuestion_id(question.getId()));
        if (temp.getTest() != null)
            temp.getTest().setTest_id(question.getId());
        return questionRepository.save(temp);
    }

    @PutMapping("{questionId}")
    public Question updateQuestion(@PathVariable Long questionId, @Valid @RequestBody Question questionRequest, Pageable pageable) {
        return questionRepository.findById(questionId).map(question -> {
            question.setActive(questionRequest.getActive());
            question.setScore(questionRequest.getScore());
            question.setText(questionRequest.getText());

            List<Answer> tempList = question.getAnswerList();
            tempList.forEach(answer -> answerRepository.delete(answer));

            testRepository.delete(question.getTest());

//            questionRequest.getAnswerList().forEach(answer -> {
//                if (answer.getQuestion_id() == null)
//                    throw new ParameterNotSpecifiedException("You should specify question_id");
//            });
            question.setAnswerList(questionRequest.getAnswerList());

            if (questionRequest.getTest().getTest_id() == null)
                throw new ParameterNotSpecifiedException("You should specify test_id");
            question.setTest(questionRequest.getTest());

            Question temp = questionRepository.save(question);
            temp.getAnswerList().forEach(answer -> answer.setQuestion_id(question.getId()));
            temp.getTest().setQuestion_id(question.getId());

            return questionRepository.save(temp);
        }).orElseThrow(() -> new ResourceNotFoundException("Question " + questionId + " not found!"));
    }

    @DeleteMapping("{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
        return questionRepository.findById(questionId).map(question -> {
            questionRepository.delete(question);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Question " + questionId + " not found!"));
    }

    @GetMapping("{questionId}/answers")
    public Page<Answer> getAllQustionAnswers(@PathVariable Long questionId, Pageable pageable) {
        return answerRepository.findByQuestionId(questionId, pageable);
    }

    @PostMapping("{questionId}/answers")
    public Answer createAnswer(@Valid @PathVariable Long questionId, @RequestBody Answer answer) {
        answer.setQuestion(questionRepository.findById(questionId).orElseThrow(), questionId);
        return answerRepository.save(answer);
    }

    @DeleteMapping("{questionId}/answers/{answerId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId, @PathVariable Long answerId) {
        return answerRepository.findByIdAndQuestionId(answerId, questionId).map(answer -> {
            answerRepository.delete(answer);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Question " + questionId + " not found!"));
    }


}
