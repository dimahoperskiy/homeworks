import models.*;
import services.AutoService;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        UserService userService = new UserService();
        AutoService autoService = new AutoService();

        User user1 = new User("Masha",26);
        userService.saveUser(user1);

        Auto ferrari = new Auto("Ferrari", "red");
        user1.addAuto(ferrari);

        Auto ford = new Auto("Ford", "black");
        user1.addAuto(ford);

        userService.updateUser(user1);

        User user2 = new User("Anton",20);
        userService.saveUser(user2);

        Auto merc = new Auto("Mercedes", "white");
        user2.addAuto(merc);

        userService.updateUser(user2);

        User user3 = new User("John", 5);
        userService.deleteUser(user3);


        User user4 = new User("Nastya", 19);

        Auto bmw = new Auto("bmw", "black");
        Auto audi = new Auto("audi", "black");
        Auto kia = new Auto("kia", "yellow");

        user4.setAutoList(new ArrayList<>(List.of(bmw, audi, kia)));
        userService.saveUser(user4);

        user4.removeAuto(kia);

        Auto lada = new Auto("lada", "purple");
        autoService.saveAuto(lada);

        Auto skoda = new Auto("skoda", "yellow");
        autoService.saveAuto(skoda);

        skoda.addAutoToUser(user1);
        autoService.updateAuto(skoda);


        System.out.println("------------------------------------------");
        System.out.println(userService.findUser(1));
        System.out.println("------------------------------------------");
        System.out.println(userService.findAllUsers());
        System.out.println("------------------------------------------");
        System.out.println(userService.findAuto(2).getUser());
        System.out.println("------------------------------------------");
        System.out.println(userService.findAuto(1));
        System.out.println("------------------------------------------");
        System.out.println(user4.getAutoList());
        System.out.println("------------------------------------------");
        System.out.println(autoService.findAllAutos());
        System.out.println("------------------------------------------");
        System.out.println(user1.getAutoList());




    }
}
