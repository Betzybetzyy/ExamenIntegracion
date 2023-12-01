/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petsmile.models;

/**
 *
 * @author nico_
 */
public class PetEntity {
    private String id;
    private String rut;
    private String tipomascota;
    private String edad;
    private String nombremascota;

    public PetEntity() {
    }

    public PetEntity(String id, String rut, String tipomascota, String edad, String nombremascota) {
        this.id = id;
        this.rut = rut;
        this.tipomascota = tipomascota;
        this.edad = edad;
        this.nombremascota = nombremascota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTipomascota() {
        return tipomascota;
    }

    public void setTipomascota(String tipomascota) {
        this.tipomascota = tipomascota;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(String nombremascota) {
        this.nombremascota = nombremascota;
    }
    
    
}
