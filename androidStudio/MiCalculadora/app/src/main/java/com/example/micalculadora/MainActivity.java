package com.example.micalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Double[] num1 = {0.00};
        final Double[] num2 = {0.00};
        final Double[] resultado = new Double[1];
        final String[] operacion = {""};

        Button btnigual = (Button) findViewById(R.id.igual);
        Button btnnum0 = (Button) findViewById(R.id.num0);
        Button btnnum1 = (Button) findViewById(R.id.num1);
        Button btnnum2 = (Button) findViewById(R.id.num2);
        Button btnnum3 = (Button) findViewById(R.id.num3);
        Button btnnum4 = (Button) findViewById(R.id.num4);
        Button btnnum5 = (Button) findViewById(R.id.num5);
        Button btnnum6 = (Button) findViewById(R.id.num6);
        Button btnnum7 = (Button) findViewById(R.id.num7);
        Button btnnum8 = (Button) findViewById(R.id.num8);
        Button btnnum9 = (Button) findViewById(R.id.num9);
        Button btnsumar = (Button) findViewById(R.id.sumar);
        Button btnrestar = (Button) findViewById(R.id.restar);
        Button btndividir = (Button) findViewById(R.id.dividir);
        Button btnmultiplicar = (Button) findViewById(R.id.multiplicar);
        Button btnpunto = (Button) findViewById(R.id.punto);
        Button btnborrar = (Button) findViewById(R.id.borrar);

        TextView txtresultado = (TextView) findViewById(R.id.txtresultado);

        btnigual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                num2[0] = Double.valueOf(String.valueOf(txtresultado.getText()));

                if (operacion[0].equals("sumar")) {
                    resultado[0] = num1[0] + num2[0];
                    txtresultado.setText(String.valueOf(resultado[0]));
                } else if (operacion[0].equals("restar")) {
                    resultado[0] = num1[0] - num2[0];
                    txtresultado.setText(String.valueOf(resultado[0]));
                } else if (operacion[0].equals("multiplicar")) {
                    resultado[0] = num1[0] * num2[0];
                    txtresultado.setText(String.valueOf(resultado[0]));
                } else if (operacion[0].equals("dividir")) {
                    resultado[0] = num1[0] / num2[0];
                    txtresultado.setText(String.valueOf(resultado[0]));
                }
            }
        });

        btnpunto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append(".");
            }
        });

        btnnum0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append("0");
            }
        });

        btnnum1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append("1");
            }
        });

        btnnum2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append("2");
            }
        });

        btnnum3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append("3");
            }
        });

        btnnum4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append("4");
            }
        });

        btnnum5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append("5");
            }
        });

        btnnum6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append("6");
            }
        });

        btnnum7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append("7");
            }
        });

        btnnum8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append("8");
            }
        });

        btnnum9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                txtresultado.append("9");
            }
        });

        btnsumar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                num1[0] = Double.valueOf(String.valueOf(txtresultado.getText()));
                txtresultado.setText("");
                operacion[0] = "sumar";
            }
        });

        btnrestar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                num1[0] = Double.valueOf(String.valueOf(txtresultado.getText()));
                txtresultado.setText("");
                operacion[0] = "restar";
            }
        });

        btndividir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                num1[0] = Double.valueOf(String.valueOf(txtresultado.getText()));
                txtresultado.setText("");
                operacion[0] = "dividir";
            }
        });

        btnmultiplicar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                num1[0] = Double.valueOf(String.valueOf(txtresultado.getText()));
                txtresultado.setText("");
                operacion[0] = "multiplicar";
            }
        });

        btnborrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                num1[0] = 0.00;
                num2[0] = 0.00;
                txtresultado.setText("");
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}