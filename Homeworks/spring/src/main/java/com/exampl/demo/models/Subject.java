package com.exampl.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "subjects")
public class Subject extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<TestList> testListList;


    public void addTestList(TestList testList) {
        testListList.add(testList);
        testList.setSubject(this);
    }

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
        testListList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "row_id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<TestList> getTestListList() {
        return testListList;
    }

    public void setTestListList(List<TestList> testListList) {
        for (TestList testList: testListList) {
            testList.setSubject(this);
        }
        this.testListList = testListList;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
