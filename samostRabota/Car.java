package com.hw.homeworks.samostRabota;

abstract class Car {
    protected String color;
    protected int maxSpeed;
    protected String gears;
    protected int curSpeed;
    protected int price;
    protected String type;

    public void start(){
        this.curSpeed += (1.0 / 10) * maxSpeed; // стартует машина с 0.1 скоростью от масимальной
    }

    public void accelerate(int accel){
        if (this.curSpeed + accel <= this.maxSpeed){
            this.curSpeed += accel;
        } else
            System.out.println("you can't accelerate that much");
    }

    public void stop(){
        this.curSpeed = 0;
    }

    public int getCurSpeed() {
        return curSpeed;
    }
}
