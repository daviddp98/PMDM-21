package com.example.proyectobdandroidv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText nombreEt, edadEt, descEt;
    Button saveBt, leerTodoBt, leerByName, leerById;
    Usuario usuario;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        configView();
    }

    private void configView() {
        usuario = new Usuario();
        nombreEt = findViewById(R.id.mainActivityEtNombre);
        edadEt = findViewById(R.id.mainActivityEtEdad);
        descEt = findViewById(R.id.mainActivityEtDesc);

        saveBt = findViewById(R.id.mainActivityBtSave);
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario.setNombre(nombreEt.getText().toString());
                usuario.setEdad(Integer.parseInt(edadEt.getText().toString()));
                usuario.setDescripcion(descEt.getText().toString());
                UsuarioBD.addUsuario(usuario);
            }
        });

        leerTodoBt = findViewById(R.id.mainActivityBtReadAll);
        leerTodoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioBD.getAllUsuario();
            }
        });

        leerByName = findViewById(R.id.mainActivityBtReadByName);
        leerByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioBD.getUsuarioByName(nombreEt.getText().toString());
            }
        });

        leerById = findViewById(R.id.mainActivityBtReadById);
        leerById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioBD.getUsuarioById(Integer.parseInt(nombreEt.getText().toString()));
            }
        });
    }
}