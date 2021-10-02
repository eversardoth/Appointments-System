package com.example.C35.entity;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class AppRole implements GrantedAuthority {

    @Id
    @SequenceGenerator(name="role_sequence",sequenceName = "role_sequence")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "role_sequence")
    private Long id;
    private String name;


    public AppRole() {
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
