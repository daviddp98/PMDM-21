package com.example.buscaminas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private ArrayList tablero;
    private int[][] botones;
    private int columnasBotones = 8;
    private int columnasTablero = 8;
    private int minas = 10;

    private String[][] tableroMinas;
    private GridView gView;
    private Button btn;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarTablero();
        gView = (GridView) findViewById(R.id.gv);
        btn = (Button) findViewById(R.id.btnReiniciar);
        gView.setNumColumns(columnasBotones); // Crea el Grid
        gView.setAdapter(new Adaptador(tablero));

        mediaPlayer = MediaPlayer.create(this, R.raw.bom);
    }

    public void reiniciar(View v) {
        iniciarTablero();
        gView = (GridView) findViewById(R.id.gv);
        btn = (Button) findViewById(R.id.btnReiniciar);
        gView.setNumColumns(columnasBotones); // Crea el Grid
        gView.setAdapter(new Adaptador(tablero));
    }

    public void iniciarTablero() {
        ponerBotones();
        tableroBotones();
        tableroMinas();
        comprobacion();
    }

    public void ponerBotones() {
        this.tablero = new ArrayList();
        int btns = this.columnasBotones * this.columnasBotones;

        for (int i = 0; i < btns; i++) {
            btn = new Button(this);
            btn.setOnClickListener(this);
            btn.setOnLongClickListener(this);
            btn.setId(i);
            btn.setBackground(this.getResources().getDrawable(R.drawable.button_border));
            btn.setTextColor(Color.BLACK);

            tablero.add(btn);
        }
    }

    public void tableroBotones() {
        int cont = 0;
        this.botones = new int[columnasTablero][columnasTablero];

        for (int i = 0; i < this.columnasTablero - 1; i++) {
            for (int j = 0; j < this.columnasTablero - 1; j++) {
                if (j > 0 && i > 0 && j < this.columnasTablero - 1 && i < this.columnasTablero - 1) {
                    btn = (Button) tablero.get(cont);
                    this.botones[i][j] = btn.getId();
                    cont++;
                }
            }
        }
    }

    public void tableroMinas() { //Para colocar la bomba
        tableroMinas = new String[columnasTablero][columnasTablero];
        int cont = 0;

        do {
            double i = Math.random() * this.columnasBotones;
            i = (int) i;
            double j = Math.random() * this.columnasBotones;
            j = (int) j;

            if (j > 0 && i > 0 && j < this.columnasTablero - 1 && i < this.columnasTablero - 1) {
                tableroMinas[(int) i][(int) j] = "*";
                cont++;
            }
        }
        while (cont <= this.minas);
    }

    public void comprobacion() {
        for (int i = 0; i < this.columnasTablero - 1; i++) {
            for (int j = 0; j < this.columnasTablero - 1; j++) {
                int numBtn = 0;//Numero del boton

                if (j > 0 && i > 0 && j < this.columnasTablero - 1 && i < this.columnasTablero - 1) {
                    if (this.tableroMinas[i][j] != ("*")) {
                        if (this.tableroMinas[i][j - 1] == "*") {
                            numBtn++;
                        }
                        if (this.tableroMinas[i - 1][j - 1] == "*") {
                            numBtn++;
                        }
                        if (this.tableroMinas[i + 1][j - 1] == "*") {
                            numBtn++;
                        }
                        if (this.tableroMinas[i][j + 1] == "*") {
                            numBtn++;
                        }
                        if (this.tableroMinas[i + 1][j + 1] == "*") {
                            numBtn++;
                        }
                        if (this.tableroMinas[i - 1][j + 1] == "*") {
                            numBtn++;
                        }
                        if (this.tableroMinas[i + 1][j] == "*") {
                            numBtn++;
                        }
                        if (this.tableroMinas[i - 1][j] == "*") {
                            numBtn++;
                        }
                        if (numBtn != 0) {
                            this.tableroMinas[i][j] = (String.valueOf(numBtn));
                        } else {
                            this.tableroMinas[i][j] = "";
                        }
                    }
                }
            }
        }
    }

    public void estadoBotones() {
        Button btn;

        for (int i = 0; i < columnasTablero; i++) {
            for (int j = 0; j < columnasTablero; j++) {
                if (j > 0 && i > 0 && j < columnasTablero - 1 && i < columnasTablero - 1) {
                    btn = (Button) gView.getAdapter().getItem(botones[i][j]);
                    btn.setText(tableroMinas[i][j]);
                    btn.setEnabled(false);
                    btn.setBackground(this.getResources().getDrawable(R.drawable.button_border2));

                    if (tableroMinas[i][j] == "*") {
                        btn.setBackground(this.getResources().getDrawable(R.drawable.button_border3));
                        mediaPlayer.start();
                    }
                }
            }
        }
    }

    public void textoBotones(int i, int j) {// Cambia las propiedades del boton pulsado y muestra el numero
        Button btn;

        btn = (Button) gView.getAdapter().getItem(botones[i][j]);
        btn.setText(tableroMinas[i][j]);
        btn.setEnabled(false);
        btn.setBackground(this.getResources().getDrawable(R.drawable.button_border2));

        if (tableroMinas[i][j] == "") {
            btn.setEnabled(false);
        } else {
            btn.setEnabled(false);
        }

        if (btn.getText() == "*") {
            Toast.makeText(this, "HAS PERDIDO.....", Toast.LENGTH_LONG).show();
            estadoBotones();
        }
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < columnasTablero - 1; i++) {
            for (int j = 0; j < columnasTablero - 1; j++) {
                if (j > 0 && i > 0 && j < columnasTablero - 1 && i < columnasTablero - 1) {
                    if (v.getId() == botones[i][j]) {
                        textoBotones(i, j);
                    }
                }
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        for (int i = 0; i < columnasTablero - 1; i++) {
            for (int j = 0; j < columnasTablero - 1; j++) {
                if (j > 0 && i > 0 && j < columnasTablero - 1 && i < columnasTablero - 1) {
                    if (v.getId() == botones[i][j]) {
                        v.setBackgroundColor(Color.RED);
                        Toast.makeText(this, "MINA MARCADA", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        return true;
    }
}