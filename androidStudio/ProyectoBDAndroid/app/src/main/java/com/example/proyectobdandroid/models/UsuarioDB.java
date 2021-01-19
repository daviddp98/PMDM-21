package com.example.proyectobdandroid.models;

import com.example.proyectobdandroid.app.MyApp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UsuarioDB extends RealmObject {

    @PrimaryKey
    private long id;
    private String nombre;
    private int edad;
    private String descripcion;
    private String urlFoto;

    public UsuarioDB() {
        this.id = MyApp.UsuarioID.incrementAndGet();
    }

    public UsuarioDB(String nombre, int edad, String descripcion, String urlFoto) {
        this.id = MyApp.UsuarioID.incrementAndGet();
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
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

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "UsuarioDB{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}