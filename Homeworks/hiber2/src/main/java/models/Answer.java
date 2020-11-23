package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String text;
    private Boolean correct;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Question question;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public int getRow_id() {
        return row_id;
    }
}
