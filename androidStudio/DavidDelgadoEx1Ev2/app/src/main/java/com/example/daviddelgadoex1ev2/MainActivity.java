package com.example.daviddelgadoex1ev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentListado.PersonasListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado frgListado= (FragmentListado) getSupportFragmentManager()
                .findFragmentById(R.id.FrgListado);

        frgListado.setPersonasListener(this);
    }

    @Override
    public void onListenerNombre(Persona c) {
        boolean hayDetalle =(getSupportFragmentManager().findFragmentById(R.id.FrgDetalle) != null);

        if (hayDetalle) {
            ((FragmentDetalle) getSupportFragmentManager()
                    .findFragmentById(R.id.FrgDetalle)).mostrarDetalle(c.getTexto());
        } else {
            Intent i = new Intent(this, DetalleActivity.class);
            startActivity(i);
        }
    }
}