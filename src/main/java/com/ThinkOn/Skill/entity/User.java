package com.ThinkOn.Skill.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="USERT")
@Entity
public class User {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="USER_NAME",nullable = false, length = 50)
    private String userName;

    @Column(name="FIRST_NAME",nullable = false, length = 50)
    private String firstName;

    @Column(name="LAST_NAME",nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(name="PHONE_NUMBER" , nullable = false, length = 50)
    private int phoneNumber;


}
