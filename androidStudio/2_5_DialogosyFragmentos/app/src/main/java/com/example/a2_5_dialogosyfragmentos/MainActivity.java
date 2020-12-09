package com.example.a2_5_dialogosyfragmentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoSexo.RespuestaDialogoSexo {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRespuesta(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    public void click(View v) {
        DialogoSexo ds = new DialogoSexo();
        ds.show(getFragmentManager(), "Mi diálogo");
    }
}