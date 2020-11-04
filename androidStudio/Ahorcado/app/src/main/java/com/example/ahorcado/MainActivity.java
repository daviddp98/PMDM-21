package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvPalabraScreta;
    EditText etLetra;
    Button btnComprobar;
    TextView tvIntentos;
    TextView tvNumIntentos;
    TextView tvLetra1;
    TextView tvLetra2;
    TextView tvLetra3;
    TextView tvLetra4;
    TextView tvLetra5;

    int intentos = 5;
    int letrasencontradas = 0;
    String[] letras;
    String palabraSecreta;
    boolean letraencontrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPalabraScreta = (TextView) findViewById(R.id.tvPalabraSecreta);
        tvIntentos = (TextView) findViewById(R.id.tvIntentos);
        tvNumIntentos = (TextView) findViewById(R.id.tvNumIntentos);
        etLetra = (EditText) findViewById(R.id.etLetra);
        btnComprobar = (Button) findViewById(R.id.btnComprobar);
        tvLetra1 = (TextView) findViewById(R.id.tvLetra1);
        tvLetra2 = (TextView) findViewById(R.id.tvLetra2);
        tvLetra3 = (TextView) findViewById(R.id.tvLetra3);
        tvLetra4 = (TextView) findViewById(R.id.tvLetra4);
        tvLetra5 = (TextView) findViewById(R.id.tvLetra5);

        tvPalabraScreta.setEnabled(false);
        tvNumIntentos.setText(String.valueOf(intentos));

        ArrayList<String> palabras = new ArrayList<>();
        palabras.add("D A V I D");
        palabras.add("M O V I L");
        palabras.add("A N T E S");
        palabras.add("Z U R D O");
        palabras.add("R A T O N");
        palabras.add("A G U A S");
        palabras.add("F U E G O");
        palabras.add("A I R E S");


        int palabrasuerte = (int) (2 * Math.random());

        letras = palabras.get(palabrasuerte).split(" ");
        palabraSecreta = palabras.get(palabrasuerte).replace(" ", "");

        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String letraintroducida = etLetra.getText().toString();
                letraencontrada = false;

                for (int i = 0; i < letras.length; i++) {

                    if (letraintroducida.equalsIgnoreCase(letras[i])) {
                        letraencontrada = true;
                        if (i == 0) {
                            tvLetra1.setText(letras[0]);
                        } else if (i == 1) {
                            tvLetra2.setText(letras[1]);
                        } else if (i == 2) {
                            tvLetra3.setText(letras[2]);
                        } else if (i == 3) {
                            tvLetra4.setText(letras[3]);
                        } else if (i == 4) {
                            tvLetra5.setText(letras[4]);
                        }
                        letrasencontradas++;
                    }

                }

                if (letraencontrada == false) {
                    intentos--;
                    tvNumIntentos.setText(String.valueOf(intentos));
                }

                if (intentos == 0) {
                    btnComprobar.setEnabled(false);
                    etLetra.setEnabled(false);
                    tvPalabraScreta.setText("¡HAS PERDIDO!");
                } else if (letrasencontradas == 5) {
                    btnComprobar.setEnabled(false);
                    etLetra.setEnabled(false);
                    tvPalabraScreta.setText("¡HAS GANADO!");
                }

            }
        });

    }

}
