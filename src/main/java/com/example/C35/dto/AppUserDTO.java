package com.example.C35.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Set;

@JsonIgnoreProperties (ignoreUnknown = true)
public class AppUserDTO implements Serializable {

    private String nombre;
    private String username;
    private String email;
    private String password;
    private Boolean enabled;
    private Set<Long> idRoles;

    public AppUserDTO() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Long> getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Set<Long> idRoles) {
        this.idRoles = idRoles;
    }
}
