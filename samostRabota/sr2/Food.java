package com.hw.homeworks.samostRabota.sr2;

import java.util.HashSet;

public class Food extends Menu {

    public Food(String name, double price, int amount, HashSet<String> consistency) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.consistency = consistency;
        menu.add(this);
        menuHashMap.put(name, this);

        if (amount == 0)
            stopList.put(name, this);
    }


}
