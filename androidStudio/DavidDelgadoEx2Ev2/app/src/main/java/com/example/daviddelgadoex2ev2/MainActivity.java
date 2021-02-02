package com.example.daviddelgadoex2ev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements OnNuevoContactoListener {

    DialogFragment dialogoNuevaAveria;
    Button btnAñadir, btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Contacto contacto = new Contacto();

        btnAñadir = (Button) findViewById(R.id.btnAñadir);
        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoNuevaAveria = new NuevoContactoFragment();
                dialogoNuevaAveria.show(getSupportFragmentManager(), "NuevaContactoFragment");
            }
        });
    }

    @Override
    public void onContactoGuardarClickListener() {
        Toast.makeText(this, "Se ha recibido el contacto guardado", Toast.LENGTH_SHORT).show();
    }
}