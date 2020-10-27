package com.hw.homeworks.samostRabota.sr1;

public class Lada extends Car {


    public Lada(String color, int maxSpeed, int price){
        this.gears = "Manual";
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.curSpeed = 0;
        this.type = "Lada";

    }
}
