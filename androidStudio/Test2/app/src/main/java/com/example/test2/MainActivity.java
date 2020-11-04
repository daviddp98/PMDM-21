package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        RadioGroup.OnCheckedChangeListener, CheckBox.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup r = (RadioGroup) findViewById(R.id.radioGroup);
        r.setOnCheckedChangeListener(this);

        CheckBox b = (CheckBox) findViewById(R.id.checkBox);
        b.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup r, int a) {
        TextView t = (TextView) findViewById(R.id.textRes);

        switch (a) {
            case R.id.radioButtonBetis: //Betis
                t.setText("Viva er Beti manquepierda!!");
                break;

            case R.id.radioButtonSev: //Sevilla
                t.setText("La escoria de la ciudad...");
                break;

            case R.id.radioButtonRM: //Madrid
                t.setText("El ladrón de LaLiga");
                break;

            case R.id.radioButtonFCB: //Barça
                t.setText("El equipo con el mejor jugador del mundo!");
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton c, boolean b) {
        TextView t = (TextView) findViewById(R.id.textRes);

        if (b)
            t.setText("Te gusta el fútbol!!");
        else
            t.setText("No te gusta el fútbol?!??!!");
    }
}