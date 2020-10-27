package com.hw.homeworks.samostRabota.sr1;

import java.util.*;

public class Garage {
    int maxVolume;
    int curVolume = 0;
    ArrayList<Car> li = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public Garage(int maxVolume){
        this.maxVolume = maxVolume;
    }

    public void add(Car car){
        if (curVolume <= maxVolume){
            li.add(car);
            map.compute(car.type, (k, v)->v==null?1:v+1);
        }
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public ArrayList<Car> getLi() {
        return li;
    }
}
