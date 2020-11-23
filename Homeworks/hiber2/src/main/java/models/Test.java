package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    TestList testList;

    @OneToOne
    @JoinColumn(name = "question_id")
    Question question;

//    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<StudentAnswer> studentAnswerList;

    public Test() {
    }

    public Test(Question question) {
        question.test = this;
        this.question = question;
    }


    public TestList getTestList() {
        return testList;
    }

    public void setTestList(TestList testList) {
        this.testList = testList;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
