package com.example.proyectobdandroidv3;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Usuario extends RealmObject {

    @PrimaryKey
    private long id;
    private String nombre;
    private int edad;
    private String descripcion;

    public Usuario() {
        this.id = MyApp.UsuarioID.incrementAndGet();
    }

    public Usuario(String nombre, int edad, String descripcion) {
        this.id = MyApp.UsuarioID.incrementAndGet();
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "; Nombre: " + getNombre() + "; Edad: " + getEdad() + "; Descripción: " + getDescripcion() + "\n";
    }
}