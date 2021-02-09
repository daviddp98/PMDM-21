package com.example.daviddelgadoex2ev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnNuevoContactoListener, OnEliminarContactoListener {

    DialogFragment dialogoNuevoContacto, dialogoEliminarContacto;
    Button btnAñadir, btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contacto> contactos = new ArrayList<Contacto>();

        btnAñadir = (Button) findViewById(R.id.btnAñadir);
        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoNuevoContacto = new NuevoContactoFragment();
                dialogoNuevoContacto.show(getSupportFragmentManager(), "NuevoContactoFragment");
            }
        });

        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoEliminarContacto = new EliminarContactoFragment();
                dialogoEliminarContacto.show(getSupportFragmentManager(), "EliminarContactoFragment");
            }
        });
    }

    @Override
    public void onContactoGuardarClickListener(DialogFragment dialogoNuevoContacto) {
        Toast.makeText(this, "Se ha recibido el contacto guardado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onContactoEliminarClickListener(DialogFragment dialogoEliminarContacto) {
        Toast.makeText(this, "Se ha eliminado el contacto", Toast.LENGTH_SHORT).show();
    }
}