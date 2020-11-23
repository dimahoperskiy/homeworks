package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
        userList = new ArrayList<>();
    }

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    List<User> userList;

    @Override
    public String toString() {
        return "Role{" +
                "row_id=" + row_id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setUser(User user) {
        userList.add(user);
        user.setRole(this);
    }

    public void setUserList(List<User> userList) {
        for (User user: userList) {
            user.setRole(this);
        }
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRow_id() {
        return row_id;
    }


}
