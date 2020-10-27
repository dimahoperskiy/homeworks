package com.hw.homeworks.samostRabota.sr2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Menu {

    String name;
    double price;
    int amount;
    HashSet<String> consistency;

    static HashMap<String, Menu> stopList = new HashMap<>();

    static ArrayList<Menu> menu = new ArrayList<>();
    static HashMap<String, Menu> menuHashMap = new HashMap<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setConsistency(HashSet<String> consistency) {
        this.consistency = consistency;
    }

    public static void addAmount(String name, int amount) {
        if (Menu.menuHashMap.containsKey(name)) {
            Menu.menuHashMap.get(name).setAmount(Menu.menuHashMap.get(name).amount + amount);
            Menu.stopList.remove(name);
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", price=" + price + '$' +
                ", amount=" + amount +
                ", consistency=" + consistency +
                '}';
    }

    public static void printMenu() {
        for (Menu value : menu) {
            System.out.println(value.toString());
        }
    }

    public static void printStopList() {
        for (String value: stopList.keySet()) {
            System.out.println(stopList.get(value).toString());
        }
    }
}
