package models;

import services.AutoService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autoList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(){}

    public User(String name, int age){
        this.name = name;
        this.age = age;
        autoList = new ArrayList<>();
    }

    public List<Auto> getAutoList() {
        return autoList;
    }

    public void setAutoList(List<Auto> autoList) {
        for (Auto auto: autoList) {
            auto.setUser(this);
        }
        this.autoList = autoList;
    }

    public void addAuto(Auto auto){
        auto.setUser(this);
        autoList.add(auto);
    }

    public void removeAuto(Auto auto){
        AutoService autoService = new AutoService();
        autoService.deleteAuto(auto);
        autoList.remove(auto);
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
