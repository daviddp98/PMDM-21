package com.example.holausuario3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarHolaUsuario3(View view) {
        Intent intentHola= new Intent(this, MainActivity2.class);

        EditText campoTextoN = (EditText) findViewById(R.id.txtNombre);
        String n= campoTextoN.getText().toString();
        EditText campoTextoE = (EditText) findViewById(R.id.txtEdad);
        int edad = Integer.parseInt(campoTextoE.getText().toString());

        intentHola.putExtra("nombre", n);
        intentHola.putExtra("edad", edad);
        startActivity(intentHola);
    }
}