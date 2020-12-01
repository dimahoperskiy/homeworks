package com.exampl.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "schedules")
public class Schedule extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer duration;
    private Date start_dt;
    private Time start_time;
    private Date end_dt;
    private Time end_time;
    private Boolean active;

    public Schedule() {
    }

    public Schedule(Integer duration, Date start_dt, Time start_time, Date end_dt, Time end_time, Boolean active) {
        this.duration = duration;
        this.start_dt = start_dt;
        this.start_time = start_time;
        this.end_dt = end_dt;
        this.end_time = end_time;
        this.active = active;
        TestList testList;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    Group group;
    @Column(name = "group_id")
    private Long group_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    TestList testList;
    @Column(name = "test_id")
    private Long test_id;

    public TestList getTestList() {
        return testList;
    }

    public void setTestList(TestList testList) {
        this.testList = testList;
    }

    public void setTestList(TestList testList, Long test_id) {
        this.testList = testList;
        setTest_id(test_id);
    }

    public Group getGroup() {
        return group;
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

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public Long getId() {
        return id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getStart_dt() {
        return start_dt;
    }

    public void setStart_dt(Date start_dt) {
        this.start_dt = start_dt;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_dt() {
        return end_dt;
    }

    public void setEnd_dt(Date end_dt) {
        this.end_dt = end_dt;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
