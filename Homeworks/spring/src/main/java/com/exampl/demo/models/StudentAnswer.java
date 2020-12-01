package com.exampl.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "student_answer")
public class StudentAnswer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    User user;
    @Column(name = "user_id")
    private Long user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    TestList testList;
    @Column(name = "test_id")
    private Long test_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    Answer answer;
    @Column(name = "answer_id")
    private Long answer_id;

    public StudentAnswer() {
    }

    public void create(User user, TestList testList, Answer answer) {
        this.user = user;
        this.testList = testList;
        this.answer = answer;
//        user.getStudentAnswerList().add(this);
//        testList.getStudentAnswerList().add(this);
//        answer.getStudentAnswerList().add(this);
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
//        answer.getStudentAnswerList().add(this);
    }

    public void setAnswer(Answer answer, Long answer_id) {
        this.answer = answer;
        setAnswer_id(answer_id);
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public Long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }

    public Long getId() {
        return id;
    }

    public TestList getTestList() {
        return testList;
    }

    public void setTestList(TestList testList) {
        this.testList = testList;
    }

    public void setTestList(TestList testList, Long test_id) {
        this.testList = testList;
        setTest_id(test_id);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
//        user.getStudentAnswerList().add(this);
    }

    public void setUser(User user, Long user_id) {
        this.user = user;
        setUser_id(user_id);
    }
}
