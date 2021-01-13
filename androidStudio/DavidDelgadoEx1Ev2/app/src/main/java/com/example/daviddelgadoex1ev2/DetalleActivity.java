package com.example.daviddelgadoex1ev2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        FragmentDetalle detalle = (FragmentDetalle) getSupportFragmentManager()
                .findFragmentById(R.id.FrgDetalle);

    }
}