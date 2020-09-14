package com.hw.homeworks.hw2.task3AndTask4;

public class Ball extends SolidOfRevolution {

    public Ball(double r){
        this.r = r;
        volume = (4.0 / 3) * pi * Math.pow(this.r, 3);
    }
}
