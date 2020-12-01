package com.exampl.demo.contollers;

import com.exampl.demo.exceptions.ParameterNotSpecifiedException;
import com.exampl.demo.exceptions.ResourceNotFoundException;
import com.exampl.demo.models.*;
import com.exampl.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("studentanswers")
public class StudentAnswerController {
    @Autowired
    TestListRepository testListRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    StudentAnswerRepository studentAnswerRepository;

    @GetMapping
    public Page<StudentAnswer> getAllStudentAnswers(Pageable pageable) {
        return studentAnswerRepository.findAll(pageable);
    }

    @GetMapping("{studentAnswerId}")
    public StudentAnswer getStudentAnswerById(@PathVariable Long studentAnswerId) {
        return studentAnswerRepository.findById(studentAnswerId).orElseThrow(() -> new ResourceNotFoundException("Student Answer " + studentAnswerId + " not found"));
    }

    @PostMapping
    public StudentAnswer createStudentAnswer(@Valid @RequestBody StudentAnswer studentAnswer) {

        if (studentAnswer.getAnswer_id() == null)
            throw new ParameterNotSpecifiedException("You should specify the answer_id");
        else
            studentAnswer.setAnswer(answerRepository.findById(studentAnswer.getAnswer_id()).orElseThrow());
        if (studentAnswer.getTest_id() == null)
            throw new ParameterNotSpecifiedException("You should specify the test_id");
        else
            studentAnswer.setTestList(testListRepository.findById(studentAnswer.getTest_id()).orElseThrow());
        if (studentAnswer.getUser_id() == null)
            throw new ParameterNotSpecifiedException("You should specify the user_id");
        else
            studentAnswer.setUser(userRepository.findById(studentAnswer.getUser_id()).orElseThrow());

        return studentAnswerRepository.save(studentAnswer);
    }

    @PutMapping("{studentAnswerId}")
    public StudentAnswer updateSchedule(@PathVariable Long studentAnswerId, @Valid @RequestBody StudentAnswer studentAnswerRequest) {
        return studentAnswerRepository.findById(studentAnswerId).map(studentAnswer -> {

            if (studentAnswerRequest.getUser_id() == null)
                throw new ParameterNotSpecifiedException("You should specify the user_id");
            else
                studentAnswer.setUser(userRepository.findById(studentAnswerRequest.getUser_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "User " + studentAnswerRequest.getUser_id() + " not found!"
                        )), studentAnswerRequest.getUser_id());

            if (studentAnswerRequest.getTest_id() == null)
                throw new ParameterNotSpecifiedException("You should specify the test_id");
            else
                studentAnswer.setTestList(testListRepository.findById(studentAnswerRequest.getTest_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "TestList " + studentAnswerRequest.getTest_id() + " not found!"
                        )), studentAnswerRequest.getTest_id());

            if (studentAnswerRequest.getAnswer_id() == null)
                throw new ParameterNotSpecifiedException("You should specify the answer_id");
            else
                studentAnswer.setAnswer(answerRepository.findById(studentAnswerRequest.getAnswer_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Answer " + studentAnswerRequest.getAnswer_id() + " not found!"
                        )), studentAnswerRequest.getAnswer_id());


            return studentAnswerRepository.save(studentAnswer);

        }).orElseThrow(() -> new ResourceNotFoundException("Student Answer " + studentAnswerId + " not found!"));
    }

    @DeleteMapping("{studentAnswerId}")
    public ResponseEntity<?> deleteStudentAnswer(@PathVariable Long studentAnswerId) {
        return studentAnswerRepository.findById(studentAnswerId).map(studentAnswer -> {
            studentAnswerRepository.delete(studentAnswer);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Student Answer " + studentAnswerId + " not found!"));
    }


}
