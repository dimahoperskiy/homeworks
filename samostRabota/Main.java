package com.hw.homeworks.samostRabota;

public class Main {
    public static void main(String[] args) {
        Mercedes e200 = new Mercedes("white", 250, 3_000_000);
        Lada priora = new Lada("black", 180, 300_000);
        Garage garage = new Garage(7);

        e200.start();
        System.out.println(e200.getCurSpeed());
        e200.accelerate(175);
        System.out.println(e200.getCurSpeed());
        e200.accelerate(70);
        System.out.println(e200.getCurSpeed());

        garage.add(e200);
        garage.add(priora);
        garage.add(e200);
        garage.add(priora);
        garage.add(priora);
        garage.add(priora);


        System.out.println(garage.getLi());
        System.out.println(garage.getMap());
    }
}
