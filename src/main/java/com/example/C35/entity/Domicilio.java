package com.example.C35.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Domicilio implements Serializable {

    @Id
    @SequenceGenerator(name="escuela_sequence", sequenceName="escuela_sequence")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="escuela_sequence")
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    public Domicilio() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
