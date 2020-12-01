package com.example.buscaminas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private String[][] tableroMinas;
    private int nMinas;
    private ArrayList tablero;
    private int nColumnas, nFilas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        añadeHijos(64);
    }

    public void añadeHijos(int c) {
        GridLayout g = (GridLayout) findViewById(R.id.grid);
        Button b;

        for (int i = 0; i < c; i++) {
            b = new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            b.setId(View.generateViewId());
            b.setText("");
            g.addView(b, i);
            //b.setOnClickListener(this);
        }
    }

    public void createTableroMinas() { //Colocar la bomba
        tableroMinas = new String[nFilas][nFilas];
        double i = 0;
        double z = 0;
        int condicion = 0;

        do {
            i = Math.random() * this.nColumnas;
            z = Math.random() * this.nColumnas;
            i = (int) i;
            z = (int) z;
            if (z > 0 && i > 0 && z < this.nFilas - 1 && i < this.nFilas - 1) {
                // Botones[(int) i][(int) z].setText("B");
                tableroMinas[(int) i][(int) z] = "B";
                condicion++;
            }
        }
        while (condicion <= this.nMinas);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {

        return false;
    }
}