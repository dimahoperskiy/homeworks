package com.shop.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String secondName;
    private String thirdName;
    private Date dateOfBirth;
    private String address;

    @OneToOne(mappedBy = "userProfile")
    private User user;


}
