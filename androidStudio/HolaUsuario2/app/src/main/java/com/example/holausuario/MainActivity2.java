package com.example.holausuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras= getIntent().getExtras();
        int edad= extras.getInt("edad");
        String nombre= extras.getString("nombre");

        Toast.makeText(this, "Hola "+ nombre+ ", tienes "+ edad+" años", Toast.LENGTH_SHORT).show();
    }
}