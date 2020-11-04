package com.example.ejemplo1multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button bplay, bstop, bsoundPool;
    public MediaPlayer mp;
    public SoundPool sp;
    public int flujodemusica;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bplay = (Button) findViewById(R.id.playMp);
        bstop = (Button) findViewById(R.id.stopMp);
        bsoundPool = (Button) findViewById(R.id.playSp);
        bplay.setOnClickListener(this);
        bstop.setOnClickListener(this);
        bsoundPool.setOnClickListener(this);
        sp = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        flujodemusica = sp.load(this, R.raw.acierto, 1);
    }

    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        if (v.getId() == R.id.playMp) {
            play_mp();
        }
        if (v.getId() == R.id.stopMp) {
            stop_mp();
        }
        if (v.getId() == R.id.playSp) {
            play_sp();
        }
    }

    private void play_mp() {
// TODO Auto-generated method stub
        mp = MediaPlayer.create(this, R.raw.gato);
        mp.start();
    }

    private void stop_mp() {
// TODO Auto-generated method stub
        mp.stop();
    }

    private void play_sp() {
// TODO Auto-generated method stub
        sp.play(flujodemusica, 1, 1, 0, 0, 1);
    }
}