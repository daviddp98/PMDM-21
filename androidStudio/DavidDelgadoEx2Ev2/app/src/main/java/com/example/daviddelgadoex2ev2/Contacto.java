package com.example.daviddelgadoex2ev2;

public class Contacto {

    String nombre;
    String telef;

    public Contacto() {
    }

    public Contacto(String nombre, String telef) {
        this.nombre = nombre;
        this.telef = telef;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }
}