package com.example.daviddelgadoex2ev2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telef;
    }
}