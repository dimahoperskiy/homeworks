package com.exampl.demo.models;

import com.exampl.demo.repositories.UserRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
        userList = new ArrayList<>();
    }

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    List<User> userList;

    @Override
    public String toString() {
        return "Role{" +
                "row_id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public void addUser(User user) {
        userList.add(user);
        user.setRole(this);
    }

    public void setUserList(List<User> userList) {
        for (User user: userList) {
            user.setRole(this);
        }
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }




}
