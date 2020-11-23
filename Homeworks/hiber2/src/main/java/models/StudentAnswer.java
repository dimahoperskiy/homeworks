package models;

import javax.persistence.*;

@Entity
@Table(name = "student_answer")
public class StudentAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    TestList testList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    Answer answer;

    public StudentAnswer() {
    }

    public void create(User user, TestList testList, Answer answer) {
        this.user = user;
        this.testList = testList;
        this.answer = answer;
        user.getStudentAnswerList().add(this);
        testList.getStudentAnswerList().add(this);
        answer.getStudentAnswerList().add(this);
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
        answer.getStudentAnswerList().add(this);
    }

    public TestList getTestList() {
        return testList;
    }

    public void setTestList(TestList testList) {
        this.testList = testList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        user.getStudentAnswerList().add(this);
    }
}
