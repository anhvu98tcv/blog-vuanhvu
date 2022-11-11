package com.vuanhvu.blog.entity;

import com.vuanhvu.blog.auth.AuthenticationProvider;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String imgUrl;
    private Date createDatetime;
    private Integer status;
    private String role;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private AuthenticationProvider provider;

    @Transient
    private String salt;

}



