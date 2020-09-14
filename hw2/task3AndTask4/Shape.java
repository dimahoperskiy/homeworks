package com.hw.homeworks.hw2.task3AndTask4;

public abstract class Shape {

    final double pi = 3.14;
    double volume;


    public double getVolume() {
        return volume;
    }

    public static void main(String[] args) {
        Box box = new Box(1000);
        Pyramid pyramid = new Pyramid(50, 10);
        Cylinder cylinder = new Cylinder(10,5);
        Ball ball = new Ball(15);

        box.add(pyramid);
        box.add(cylinder);
        box.add(ball);
    }
}
