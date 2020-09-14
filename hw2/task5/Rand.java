package com.hw.homeworks.hw2.task5;

import java.util.Arrays;
import java.util.Scanner;

public class Rand {

    public static int[] nums;
    public static int[] pows;
    public static int finLen = 0;
    public static int n;
    int[] fin;

    public Rand(int[] nums, int[] power) {
        int count = 0;
        int len = Arrays.stream(power).sum();
        for (int i = 0; i < n; i++) {
           finLen += power[i];
        }
        fin = new int[finLen];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < power[i]; j++){
                fin[count++] = nums[i];
            }
        }



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во чисел в массиве: ");
        n = scanner.nextInt();
        System.out.println(" ");
        nums = new int[n];
        pows = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Введите " + i + "-й элемент массива: ");
            int num = scanner.nextInt();
            nums[i] = num;
        }
        System.out.println(" ");
        for (int i = 0; i < n; i++) {
            System.out.println("Введите вес " + i + "-ого элемента массива: ");
            int num = scanner.nextInt();
            pows[i] = num;
        }

        Rand rand = new Rand(nums, pows);



        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(pows));

        System.out.println(Arrays.toString(rand.fin));

        System.out.println(rand.fin[(int)(Math.random() * rand.fin.length)]);


    }
}
