package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Controller
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "User_Id")
    private String userId;

    @Column(name = "Password")
    private String password;


}
