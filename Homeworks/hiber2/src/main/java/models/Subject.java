package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
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
                "row_id=" + row_id +
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

    public int getRow_id() {
        return row_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
