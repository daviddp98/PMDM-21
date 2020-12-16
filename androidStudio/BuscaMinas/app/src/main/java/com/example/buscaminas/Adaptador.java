package com.example.buscaminas;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList botonesTablero;

    public Adaptador() {

    }

    public Adaptador(ArrayList bt) {
        this.botonesTablero = bt;
    }

    @Override
    public int getCount() {
        return botonesTablero.size();
    }

    @Override
    public Object getItem(int position) {
        return (Object) botonesTablero.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;

        if (convertView == null) {
            button = (Button) botonesTablero.get(position);
        } else {
            button = (Button) convertView;
        }
        return button;
    }
}