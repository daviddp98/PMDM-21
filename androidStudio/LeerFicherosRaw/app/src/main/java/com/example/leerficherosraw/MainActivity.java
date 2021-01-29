package com.example.leerficherosraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    TextView texto;
    Button btnLeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.texto);
        btnLeer = (Button) findViewById(R.id.btnLeer);

        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cargarFichero(v);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void cargarFichero(View view) throws IOException {
        String txt = new String();
        InputStream is = this.getResources().openRawResource(R.raw.fichero);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if (is != null) {
            while ((txt = reader.readLine()) != null) {
                txt = txt + reader.readLine();
                texto.setText(txt);
            }
        }
        is.close();

        Toast.makeText(this, "Leyendo...", Toast.LENGTH_LONG).show();
    }
}