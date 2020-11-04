package com.example.prgridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        añadeHijos(18);
        recorrer();
    }

    public void añadeHijos(int c) {
        GridLayout g = (GridLayout) findViewById(R.id.grid1);
        Button b;

        for (int i = 0; i < c; i++) {
            b = new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            b.setId(View.generateViewId());
            if (i == 17) {
                b.setText("RESET!");
            } else {
                b.setText("btn" + i);
            }
            g.addView(b, i);
            b.setOnClickListener(this);
        }
    }

    public void onClick(View v) {
        System.out.println("Se ha pulsado el boton " + v.toString());

        Button b;

        if (v.getClass().getSimpleName().equals("Button")) {
            b = (Button) v;
            if (b.getText().equals("RESET!")) {
                recorrer();
            } else {
                b.setBackgroundColor(Color.WHITE);
            }
        }
    }

    public void recorrer() {
        GridLayout g = (GridLayout) findViewById(R.id.grid1);
        Button b;

        System.out.println("Filas= " + g.getRowCount());
        System.out.println("Columnas= " + g.getColumnCount());

        for (int i = 0; i < g.getChildCount(); i++) {
            View v;
            v = g.getChildAt(i);
            if (v.getClass().getSimpleName().equals("Button")) {
                b = (Button) v;
                b.setBackgroundColor(Color.rgb(i * 10, i * 50, i * 30));
            }
        }
    }
}