package com.exampl.demo.contollers;

import com.exampl.demo.exceptions.ResourceNotFoundException;
import com.exampl.demo.models.Role;
import com.exampl.demo.models.Subject;
import com.exampl.demo.models.TestList;
import com.exampl.demo.models.User;
import com.exampl.demo.repositories.SubjectRepository;
import com.exampl.demo.repositories.TestListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("subjects")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TestListRepository testListRepository;


    @GetMapping
    public Page<Subject> getAllSubjects(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }

    @GetMapping("{subjectId}")
    public Subject getSubjectById(@PathVariable Long subjectId) {
        return subjectRepository.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject " + subjectId + " not found!"));
    }

    @PostMapping
    public Subject createSubject(@Valid @RequestBody Subject subject) {
        Subject temp = subjectRepository.save(subject);
        if (temp.getTestListList()!= null)
            temp.getTestListList().forEach(testList -> testList.setSubject_id(subject.getId()));
        return subjectRepository.save(temp);
    }

    @PutMapping("{subjectId}")
    public Subject updateSubject(@PathVariable Long subjectId, @Valid @RequestBody Subject subjectRequest, Pageable pageable) {
        return subjectRepository.findById(subjectId).map(subject -> {
            subject.setName(subjectRequest.getName());

            List<TestList> tempList = subject.getTestListList();
            subject.setTestListList(subjectRequest.getTestListList());
            tempList.forEach(testList -> testListRepository.delete(testList));

            Subject temp = subjectRepository.save(subject);
            temp.getTestListList().forEach(testList -> testList.setSubject_id(subject.getId()));

            return subjectRepository.save(temp);
        }).orElseThrow(() -> new ResourceNotFoundException("Subject " + subjectId + " not found!"));
    }

    @DeleteMapping("{subjectId}")
    public ResponseEntity<?> deleteSubject(@PathVariable Long subjectId) {
        return subjectRepository.findById(subjectId).map(subject -> {
            subjectRepository.delete(subject);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Subject " + subjectId + " not found!"));
    }
}

