package com.example.hundirlaflota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void añadeHijos() {
        GridLayout g = (GridLayout) findViewById(R.id.grid);
        Button b;

        for (int i = 0; i < 9; i++) {

            b = new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            //b.setText("");
            b.setId(View.generateViewId());
            b.setOnClickListener(this);
            g.addView(b, i);

        }
    }

    @Override
    public void onClick(View v) {

    }
}