package com.hw.homeworks.hw2.task1;


import java.util.Arrays;
import java.util.Scanner;

public class Matrix {

    public static int n;

    public static int[][] create () {
        int [][] m = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j=0; j < 3; j++) {
                m[i][j] = (int)(Math.random() * 10);
            }
        }
        return m;
    }


    public static int[][] add (int[][] m1, int[][] m2) {
        int[][] m3 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m3;
    }


    public static int[][] sub (int[][] m1, int[][] m2) {
        int[][] m3 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m3[i][j] = m1[i][j] - m2[i][j];
            }
        }
        return m3;
    }

    public static int[][] mul (int[][] m1, int n) {
        int[][] m3 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m3[i][j] = m1[i][j] * n;
            }
        }
        return m3;
    }


    public static void main(String[] args) {
        while (true) {
            int[][] m1 = Matrix.create();
            int[][] m2 = Matrix.create();
            int[][] m3;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите \"плюс\" или \"минус\" или \"умножить\":  ");
            String sign;

            while (true) {
                sign = scanner.next();
                if (sign.equals("плюс")) {
                    m3 = Matrix.add(m1, m2);
                    sign = "+";
                    break;
                }
                else if (sign.equals("минус")) {
                    m3 = Matrix.sub(m1, m2);
                    sign = "-";
                    break;
                }
                else if (sign.equals("умножить")) {
                    System.out.println("введите число: ");
                    n = scanner.nextInt();
                    m3 = Matrix.mul(m1, n);
                    sign = "*";
                    break;
                }
                else if (sign.equals("выход")) {
                    System.out.println("До свидания!");
                    m3 = m1;
                    break;
                }
                else
                    System.out.println("еще раз");
            }


            if (sign.equals("+")  ||  sign.equals("-")) {
                for (int i = 0; i < 3; i++) {
                    if (i == 1) {
                        System.out.print(Arrays.toString(m1[i]));
                        System.out.print("  " + sign + "  ");
                        System.out.print(Arrays.toString(m2[i]));
                        System.out.print("  =  ");
                    }
                    else {
                        System.out.print(Arrays.toString(m1[i]) + "     ");
                        System.out.print(Arrays.toString(m2[i]) + "     ");
                    }
                    System.out.println(Arrays.toString(m3[i]));
                }
            }
            else if (sign.equals("*")) {
                for (int i = 0; i < 3; i++) {
                    if (i == 1) {
                        System.out.print(Arrays.toString(m1[i]));
                        System.out.print("  " + sign + "  ");
                        System.out.print(n);
                        System.out.print("  =  ");
                    }
                    else {
                        System.out.print(Arrays.toString(m1[i]) + "           ");
                    }
                    System.out.println(Arrays.toString(m3[i]));
                }
            }
            else
                break;
        }



    }
}
