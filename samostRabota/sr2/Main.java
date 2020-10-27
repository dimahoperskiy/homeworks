package com.hw.homeworks.samostRabota.sr2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Food f1 = new Food("Fries", 10, 4,
                new HashSet<>(Arrays.asList("Potato", "Salt")));
        Food f2 = new Food("Pasta with mushrooms", 22, 3,
                new HashSet<>(Arrays.asList("Pasta", "Mushrooms", "Milk sauce")));
        Food f3 = new Food("Nuggets", 15, 6,
                new HashSet<>(Arrays.asList("Chicken", "Bread", "BBQ sauce")));
        Drinks d1 = new Drinks("Cola", 6, 10,
                new HashSet<>(Collections.singletonList("Cola")));
        Drinks d2 = new Drinks("Vodka", 15, 0,
                new HashSet<>(Collections.singletonList("Vodka")));

        Menu.printMenu();

        System.out.println("------------");

        Orders t1 = new Orders(1);

        t1.add("Fries");
        t1.add("Cola");
        t1.add("Fries");
        t1.add("Fries");
        t1.add("Fries");
        t1.add("Fries");
        t1.add("Fries");
        t1.add("Pasta with mushrooms");
        t1.add("Weed");

        System.out.println("------------");
        t1.printOrders();
        System.out.println(t1.getOrderSum());

        System.out.println("------------");
        t1.closeTable();

        System.out.println("------------");
        Menu.printMenu();

        System.out.println("------------");
        Menu.printStopList();

        Menu.addAmount("Fries", 10);

        f1.setConsistency(new HashSet<>(Arrays.asList("Potato", "Salt", "Pepper", "Ketchup")));

        System.out.println("------------");
        Menu.printMenu();

        System.out.println("------------");
        Menu.printStopList();
    }

}
