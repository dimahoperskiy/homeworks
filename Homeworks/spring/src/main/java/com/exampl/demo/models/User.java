package com.exampl.demo.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<StudentAnswer> studentAnswerList;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<TestList> testListList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", updatable = false, insertable = false)
    @JsonIgnore
    private Group group;
    @Column(name = "group_id")
    private Long group_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    private Role role;
    @Column(name = "role_id")
    private Long role_id;


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
                "row_id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", login='" + login + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", group=" + group.getId() +
                ", role=" + role.getId() +
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

    public void setRole(Role role, Long role_id) {
        this.role = role;
        setRole_id(role_id);
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setGroup(Group group, Long group_id) {
        this.group = group;
        setGroup_id(group_id);
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public Group getGroup() {
        return group;
    }

    public long getId() {
        return id;
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
