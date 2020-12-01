package com.exampl.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test_list")
public class TestList extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    private Subject subject;
    @Column(name = "subject_id")
    private Long subject_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    private User teacher;
    @Column(name = "teacher_id")
    private Long teacher_id;


    @OneToOne(mappedBy = "testList", cascade = CascadeType.ALL)
    Schedule schedule;

    @OneToMany(mappedBy = "testList", cascade = CascadeType.ALL)
    List<Test> testList;

    @OneToMany(mappedBy = "testList", cascade = CascadeType.ALL)
    private List<StudentAnswer> studentAnswerList;

    public void addSchedule(Schedule schedule) {
        this.schedule = schedule;
        schedule.setTestList(this);
    }

    public void addTest(Test test) {
        testList.add(test);
        test.setTestList(this);
    }

    public List<Test> getTestList() {
        return testList;
    }

    public List<StudentAnswer> getStudentAnswerList() {
        return studentAnswerList;
    }

    public void setStudentAnswerList(List<StudentAnswer> studentAnswerList) {
        this.studentAnswerList = studentAnswerList;
    }

    public void setTestList(List<Test> testList) {
        for (Test test: testList) {
            test.setTestList(this);
        }
        this.testList = testList;
    }

    public TestList() {
    }

    public TestList(String name) {
        this.name = name;
        testList = new ArrayList<>();
        studentAnswerList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "TestList{" +
                "row_id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject.getId() +
                '}';
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(long subject_id) {
        this.subject_id = subject_id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher, Long teacher_id) {
        this.teacher = teacher;
        setTeacher_id(teacher_id);
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject, Long subject_id) {
        this.subject = subject;
        setSubject_id(subject_id);
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
