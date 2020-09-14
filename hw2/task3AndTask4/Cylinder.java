package com.hw.homeworks.hw2.task3AndTask4;

public class Cylinder extends SolidOfRevolution {

    double h;

    public Cylinder(double h, double r) {
        this.h = h;
        this.r = r;
        volume = pi * (this.r*this.r) * this.h;
    }
}
