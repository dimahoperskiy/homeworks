package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String login;
    private String password_hash;

    public User() {
    }

    public User(String first_name, String last_name, String middle_name, String login, String password_hash) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.login = login;
        this.password_hash = password_hash;
        testListList = new ArrayList<>();
        studentAnswerList = new ArrayList<>();
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentAnswer> studentAnswerList;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestList> testListList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;



    public void addTestList(TestList testList) {
        if (this.role.getName().equals("Преподаватель") || this.role.getName().equals("Администратор")) {
            testListList.add(testList);
            testList.setTeacher(this);
        } else System.out.println("Тест может вести только преподаватель.");
    }

    public void addStudentAnswer(StudentAnswer studentAnswer) {
        studentAnswerList.add(studentAnswer);
        studentAnswer.setUser(this);
    }


    @Override
    public String toString() {
        return "User{" +
                "row_id=" + row_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", login='" + login + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", group=" + group.getRow_id() +
                ", role=" + role.getRow_id() +
                '}';
    }

    public List<TestList> getTestListList() {
        return testListList;
    }

    public List<StudentAnswer> getStudentAnswerList() {
        return studentAnswerList;
    }

    public void setStudentAnswerList(List<StudentAnswer> studentAnswerList) {
        for (StudentAnswer studentAnswer: studentAnswerList) {
            studentAnswer.setUser(this);
        }
        this.studentAnswerList = studentAnswerList;
    }

    public void setTestListList(List<TestList> testListList) {
        for (TestList testList: testListList) {
            testList.setTeacher(this);
        }
        this.testListList = testListList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getRow_id() {
        return row_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
}
