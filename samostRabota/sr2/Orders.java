package com.hw.homeworks.samostRabota.sr2;

import java.util.ArrayList;

public class Orders {

    int tableNum;
    double orderSum;
    ArrayList<Menu> orders = new ArrayList<>();

    public Orders(int tableNum) {
        this.tableNum = tableNum;
    }

    public void add(String name) {
        if (Menu.menuHashMap.containsKey(name)) {
            if (Menu.menuHashMap.get(name).amount == 0) {
                Menu.stopList.put(name, Menu.menuHashMap.get(name));
                System.out.println("We're sorry, " + name + " is over.");
            } else {
                Menu.menuHashMap.get(name).setAmount(Menu.menuHashMap.get(name).amount - 1);
                setOrderSum(Menu.menuHashMap.get(name).price);
                orders.add(Menu.menuHashMap.get(name));
                System.out.println(name + " is added to your order.");
            }
        } else
            System.out.println("We're sorry, " + name + " is not in our menu.");
    }

    public void printOrders() {
        System.out.println("Table name " + tableNum);
        for (Menu value : orders) {
            System.out.println(value.toString());
        }
    }

    public void closeTable() {
        System.out.println("Table name " + tableNum);
        orders.clear();
        setOrderSum(0);
        System.out.println("Table is closed");
    }

    public void setOrderSum(double orderSum) {
        this.orderSum += orderSum;
    }

    public double getOrderSum() {
        return orderSum;
    }
}
