package com.hw.homeworks.hw2.task2;

import java.util.Arrays;
import java.util.Scanner;

public class VecMath {

    public int skaMul(Vector v1, Vector v2) {
        return (v1.x * v2.x + v1.y * v2.y + v1.z * v2.z);
    }

    public Vector vecMul(Vector v1, Vector v2) {
        int x = v1.y * v2.z - v1.z * v2.y;
        int y = v1.z * v2.x - v1.x * v2.z;
        int z = v1.x * v2.y - v1.y * v2.x;
        return new Vector(x, y, z);

    }

    public double cos(Vector v1, Vector v2) {
        VecMath m = new VecMath();
        int s = m.skaMul(v1, v2);
        return (double)s / (v1.len() + v2.len());
    }

    public static int[][] rand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во векторов: ");
        int n = scanner.nextInt();
        int[][] li = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                li[i][j] = (int)(Math.random() * 10);
            }
        }
        return li;

    }



    public static void main(String[] args) {
        Vector v1 = new Vector(3, 4, 5);
        Vector v2 = new Vector(5, 2, 6);
        VecMath m = new VecMath();
        System.out.println(m.skaMul(v1, v2));
        m.vecMul(v1, v2).print();
        System.out.println(v1.len());
        System.out.println(m.cos(v1, v2));
        System.out.println(Arrays.deepToString(rand()));

    }
}
