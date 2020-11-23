package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test_list")
public class TestList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @OneToOne(mappedBy = "testList", cascade = CascadeType.ALL, orphanRemoval = true)
    Schedule schedule;

    @OneToMany(mappedBy = "testList", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Test> testList;

    @OneToMany(mappedBy = "testList", cascade = CascadeType.ALL, orphanRemoval = true)
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
                "row_id=" + row_id +
                ", name='" + name + '\'' +
                ", subject=" + subject.getRow_id() +
                '}';
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

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
