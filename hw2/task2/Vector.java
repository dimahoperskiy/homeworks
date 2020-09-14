package com.hw.homeworks.hw2.task2;

import java.util.Arrays;

public class Vector {
    int x;
    int y;
    int z;
    int[] li;

    public Vector(int x, int y, int z) {
        li = new int[]{x, y, z};
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void print() {
        System.out.println(Arrays.toString(li));
    }

    public double len() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public static void main(String[] args) {
        Vector v = new Vector(3, 4, 5);
        v.print();
        System.out.println(v.len());
    }
}
