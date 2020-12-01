package com.exampl.demo.contollers;

import com.exampl.demo.exceptions.ParameterNotSpecifiedException;
import com.exampl.demo.exceptions.ResourceNotFoundException;
import com.exampl.demo.models.Schedule;
import com.exampl.demo.models.Test;
import com.exampl.demo.models.TestList;
import com.exampl.demo.models.User;
import com.exampl.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("tests")
public class TestController {
    @Autowired
    TestListRepository testListRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    TestRepository testRepository;

    @GetMapping
    public Page<Test> getAllTests(Pageable pageable) {
        return testRepository.findAll(pageable);
    }

    @GetMapping("{testId}")
    public Test getTestById(@PathVariable Long testId) {
        return testRepository.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test " + testId + " not found"));
    }

    @PostMapping
    public Test createTest(@Valid @RequestBody Test test) {

        if (test.getQuestion_id() == null)
            throw new ParameterNotSpecifiedException("You should specify the question_id");
        else
            test.setQuestion(questionRepository.findById(test.getQuestion_id()).orElseThrow());
        if (test.getTest_id() == null)
            throw new ParameterNotSpecifiedException("You should specify the test_id");
        else
            test.setTestList(testListRepository.findById(test.getTest_id()).orElseThrow());
        return testRepository.save(test);
    }

    @PutMapping("{testId}")
    public Test updateTest(@PathVariable Long testId, @Valid @RequestBody Test testRequest) {
        return testRepository.findById(testId).map(test -> {


            if (testRequest.getQuestion_id() == null)
                throw new ParameterNotSpecifiedException("You should specify the question_id");
            else
                test.setQuestion(questionRepository.findById(testRequest.getQuestion_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Question " + testRequest.getQuestion_id() + " not found!"
                        )), testRequest.getQuestion_id());

            if (testRequest.getTest_id() == null)
                throw new ParameterNotSpecifiedException("You should specify the test_id");
            else
                test.setTestList(testListRepository.findById(testRequest.getTest_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "TestList " + testRequest.getTest_id() + " not found!"
                        )), testRequest.getTest_id());
            return testRepository.save(test);


        }).orElseThrow(() -> new ResourceNotFoundException("Test " + testId + " not found!"));
    }

    @DeleteMapping("{testId}")
    public ResponseEntity<?> deleteTest(@PathVariable Long testId) {
        return testRepository.findById(testId).map(test -> {
            testRepository.delete(test);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Test " + testId + " not found!"));
    }


}
