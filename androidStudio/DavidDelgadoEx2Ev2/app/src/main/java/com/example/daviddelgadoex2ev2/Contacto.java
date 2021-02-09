package com.example.daviddelgadoex2ev2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class Contacto extends BaseAdapter {

    String nombre;
    String telef;
    ArrayList<?> c;

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
    public int getCount() {
        return c.size();
    }

    @Override
    public Object getItem(int position) {
        return c.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}