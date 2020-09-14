package com.hw.homeworks.hw2.task3AndTask4;

public class Box extends Shape {


    public Box(double volume) {
        this.volume = volume;
    }

    public boolean add(Shape sh) {
        if (volume - sh.getVolume() >= 0) {
            volume -= sh.getVolume();
            System.out.println("Удалось");
            System.out.println("Осталось " + volume + " см^3");
            System.out.println(" ");
            return true;
        }
        else
            System.out.println("Не удалось");
            System.out.println("Осталось " + volume + " см^3");
            System.out.println(" ");
            return false;
    }
}
