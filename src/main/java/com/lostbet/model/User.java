package com.lostbet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "userdata")
public class User {
    @Id
    private long usercpf;
    private String username;
    private String useremail;
    private String userpassword;
    private Double userbalance;
}
