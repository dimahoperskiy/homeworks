package com.exampl.demo.contollers;

import com.exampl.demo.exceptions.ParameterNotSpecifiedException;
import com.exampl.demo.exceptions.ResourceNotFoundException;
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
@RequestMapping("testlists")
public class TestListController {
    @Autowired
    TestListRepository testListRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    TestRepository testRepository;

    @GetMapping
    public Page<TestList> getAllTestLists(Pageable pageable) {
        return testListRepository.findAll(pageable);
    }

    @GetMapping("{testListId}")
    public TestList getTestListById(@PathVariable Long testListId) {
        return testListRepository.findById(testListId).orElseThrow(() -> new ResourceNotFoundException("TestList " + testListId + " not found"));
    }

    @PostMapping
    public TestList createTestList(@Valid @RequestBody TestList testList) {
        TestList temp = testListRepository.save(testList);
        if (testList.getSchedule() != null)
            testList.getSchedule().setTest_id(temp.getId());

        if (testList.getTestList() != null)
            testList.getTestList().forEach(test -> test.setTest_id(temp.getId()));

        if (testList.getSubject_id() == null)
            throw new ParameterNotSpecifiedException("You should specify the subject_id");
        else
            testList.setSubject(subjectRepository.findById(testList.getSubject_id()).orElseThrow());
        if (testList.getTeacher_id() == null)
            throw new ParameterNotSpecifiedException("You should specify the teacher_id");
        else
            testList.setTeacher(userRepository.findById(testList.getTeacher_id()).orElseThrow());
        return testListRepository.save(testList);
    }

    @PutMapping("{testListId}")
    public TestList updateTestList(@PathVariable Long testListId, @Valid @RequestBody TestList testListRequest) {
        return testListRepository.findById(testListId).map(testList -> {
            testList.setName(testListRequest.getName());

            if (testList.getSchedule() != null)
                scheduleRepository.delete(testList.getSchedule());

            if (testList.getTestList() != null)
                testList.getTestList().forEach(test -> testRepository.delete(test));

            if (testListRequest.getSubject_id() == null)
                throw new ParameterNotSpecifiedException("You should specify the subject_id");
            else
                testList.setSubject(subjectRepository.findById(testListRequest.getSubject_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Subject " + testListRequest.getSubject_id() + " not found!"
                        )), testListRequest.getSubject_id());

            if (testListRequest.getTeacher_id() == null)
                throw new ParameterNotSpecifiedException("You should specify the teacher_id");
            else
                testList.setTeacher(userRepository.findById(testListRequest.getTeacher_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Teacher " + testListRequest.getTeacher_id() + " not found!"
                        )), testListRequest.getTeacher_id());

            if (testListRequest.getSchedule().getGroup_id() == null)
                throw new ParameterNotSpecifiedException("You should specify group_id");

            TestList temp = testListRepository.save(testList);

            testListRequest.getSchedule().setTest_id(temp.getId());
            testList.setSchedule(testListRequest.getSchedule());

            testListRequest.getTestList().forEach(test -> {
                if (test.getQuestion_id() == null)
                    throw new ParameterNotSpecifiedException("You should specify question_id");
            });

            testListRequest.getTestList().forEach(test -> test.setTest_id(temp.getId()));
            testList.setTestList(testListRequest.getTestList());

            return testListRepository.save(testList);

        }).orElseThrow(() -> new ResourceNotFoundException("TestList " + testListId + " not found!"));
    }

    @DeleteMapping("{testListId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long testListId) {
        return testListRepository.findById(testListId).map(testList -> {
            testListRepository.delete(testList);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("TestList " + testListId + " not found!"));
    }


}
