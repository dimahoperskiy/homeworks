package com.exampl.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "answers")
public class Answer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private Boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    Question question;
    @Column(name = "question_id")
    Long question_id;


    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<StudentAnswer> studentAnswerList;

    public Answer() {
    }

    public Answer(String text, Boolean correct) {
        this.text = text;
        this.correct = correct;
        studentAnswerList = new ArrayList<>();
    }

    public void addStudentAnswer(StudentAnswer studentAnswer) {
        studentAnswerList.add(studentAnswer);
        studentAnswer.setAnswer(this);
    }

    public List<StudentAnswer> getStudentAnswerList() {
        return studentAnswerList;
    }

    public void setStudentAnswerList(List<StudentAnswer> studentAnswerList) {
        this.studentAnswerList = studentAnswerList;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setQuestion(Question question, Long question_id) {
        this.question = question;
        setQuestion_id(question_id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public long getId() {
        return id;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }
}
