package com.example.demo.dto;



import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Set;


@Data
@SuperBuilder
public class UserDTO implements Serializable {
    private int idUser;
    private long creationDate;
    private long creationDateUser;
    private String email;
    private String lastname;
    private String name;
    private int status;
    private String username;
    private String password;
    private String token;
    private String message;
    private String orden;
    private String firstName;
    private Set<String> roles;
    public UserDTO() {
    }
    public String getLastName() {
        return this.lastname;
    }


}