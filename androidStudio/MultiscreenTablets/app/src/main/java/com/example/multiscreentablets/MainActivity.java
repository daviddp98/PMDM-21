package com.example.multiscreentablets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layoutContenedor = (LinearLayout) findViewById(R.id.contenedor);

        if (layoutContenedor != null) {
            // Tablet
            Toast.makeText(this, "Estas en una tablet", Toast.LENGTH_SHORT).show();
        } else {
            // Móvil
            Toast.makeText(this, "Estas en un móvil", Toast.LENGTH_SHORT).show();
        }
    }
}