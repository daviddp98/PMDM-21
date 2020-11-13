package com.example.ext1_daviddelgado;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ListView list;
    RadioGroup radioGroup;
    RadioButton radioButtonBajo;
    RadioButton radioButtonMedio;
    RadioButton radioButtonAlto;
    TextView textView;
    CheckBox loop;
    Button buttonPlay;
    Button buttonPause;
    Button buttonStop;
    MediaPlayer mp;

    SoundPool sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonBajo = (RadioButton) findViewById(R.id.radioButtonBajo);
        radioButtonMedio = (RadioButton) findViewById(R.id.radioButtonMedio);
        radioButtonAlto = (RadioButton) findViewById(R.id.radioButtonAlto);
        textView = (TextView) findViewById(R.id.textView2);
        loop = (CheckBox) findViewById(R.id.loop);
        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPause = (Button) findViewById(R.id.buttonPause);
        buttonStop = (Button) findViewById(R.id.buttonStop);

        sp= new SoundPool(1, AudioManager.STREAM_MUSIC,1);

       String[] audios= {"Elefante", "Caballo", "Gato", "Leon", "Pajaro", "Perro"};

       ArrayAdapter arrayAdapter= new ArrayAdapter(this, R.layout.activity_main, audios);
       list.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonPlay) {
            buttonPlay();
        }
        if (v.getId() == R.id.buttonStop) {
            buttonStop();
        }
        if (v.getId() == R.id.buttonPause) {
            buttonPause();
        }
    }

    private void buttonPause() {
        mp.pause();
    }

    private void buttonStop() {
        mp.stop();
    }

    private void buttonPlay() {
        mp = MediaPlayer.create(this, R.raw.caballo);
        mp.start();
    }
}