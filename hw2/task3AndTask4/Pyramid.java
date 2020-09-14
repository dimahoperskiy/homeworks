package com.hw.homeworks.hw2.task3AndTask4;

public class Pyramid extends Shape {

    double s;
    double h;

    public Pyramid(double s, double h) {
        this.s = s;
        this.h = h;
        volume = (1.0 / 3) * s * h;
    }
}
