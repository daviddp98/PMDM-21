package com.example.proyectobdandroidv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText nombreEt, edadEt, descEt, idEt;
    TextView textView;
    Button saveBt, leerTodoBt, leerByName, delBt, leerByID;
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
        idEt = findViewById(R.id.mainActivityEtID);
        nombreEt = findViewById(R.id.mainActivityEtNombre);
        edadEt = findViewById(R.id.mainActivityEtEdad);
        descEt = findViewById(R.id.mainActivityEtDesc);
        textView = findViewById(R.id.textView);

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

        delBt = findViewById(R.id.mainActivityBtDel);
        delBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioBD.delUsuario(Integer.parseInt(idEt.getText().toString()));
            }
        });

        leerTodoBt = findViewById(R.id.mainActivityBtReadAll);
        leerTodoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioBD.getAllUsuario(textView);
            }
        });

        leerByName = findViewById(R.id.mainActivityBtReadByName);
        leerByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioBD.getUsuarioByName(nombreEt.getText().toString(), textView);
            }
        });

        leerByID = findViewById(R.id.mainActivityBtReadByID);
        leerByID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioBD.getUsuarioById(Integer.parseInt(idEt.getText().toString()), textView);
            }
        });
    }
}