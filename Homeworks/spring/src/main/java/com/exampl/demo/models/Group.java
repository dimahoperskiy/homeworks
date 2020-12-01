package com.exampl.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends AuditModel {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Integer year;
    private Integer semester;


    public Group() {
    }

    public Group(String name, Integer year, Integer semester) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        userList = new ArrayList<>();
        scheduleList = new ArrayList<>();
    }

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<User> userList;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Schedule> scheduleList;

    @Override
    public String toString() {
        return "Group{" +
                "row_id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                '}';
    }

    public void addUser(User user) {
        userList.add(user);
        user.setGroup(this);
    }

    private void addSchedule(Schedule schedule) {
        scheduleList.add(schedule);
        schedule.setGroup(this);
    }

    public void setUserList(List<User> userList) {
        for (User user: userList) {
            user.setGroup(this);
        }
        this.userList = userList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        for (Schedule schedule: scheduleList) {
            schedule.setGroup(this);
        }
        this.scheduleList = scheduleList;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public List<User> getUserList() {
        return userList;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

}
