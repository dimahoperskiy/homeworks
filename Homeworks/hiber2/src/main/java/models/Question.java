package models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String text;
    private Integer score;
    private Boolean active;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Answer> answerList;

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    Test test;

    public void addAnswer(Answer answer) {
        answerList.add(answer);
        answer.setQuestion(this);
    }

    public Question() {
    }

    public Question(String text, Integer score, Boolean active) {
        this.text = text;
        this.score = score;
        this.active = active;
        answerList = new ArrayList<>();
        test = null;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        for (Answer answer: answerList) {
            answer.setQuestion(this);
        }
        this.answerList = answerList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getRow_id() {
        return row_id;
    }
}
