package com.example.tresenraya;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    boolean relleno = false;
    boolean relleno2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        do {
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((button1.getText() == "") && (relleno == false)) {
                        button1.setText("X");
                        relleno = true;
                        button1.setBackgroundColor(Color.GREEN);
                        juegaMaquina();
                        comprobar();
                    }
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button2.getText() == "" && (relleno == false)) {
                        button2.setText("X");
                        relleno = true;
                        button2.setBackgroundColor(Color.GREEN);
                        juegaMaquina();
                        comprobar();
                    }
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button3.getText() == "" && (relleno == false)) {
                        button3.setText("X");
                        relleno = true;
                        button3.setBackgroundColor(Color.GREEN);
                        juegaMaquina();
                        comprobar();
                    }
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button4.getText() == "" && (relleno == false)) {
                        button4.setText("X");
                        relleno = true;
                        button4.setBackgroundColor(Color.GREEN);
                        juegaMaquina();
                        comprobar();
                    }
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button5.getText() == "" && (relleno == false)) {
                        button5.setText("X");
                        relleno = true;
                        button5.setBackgroundColor(Color.GREEN);
                        juegaMaquina();
                        comprobar();
                    }
                }
            });

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button6.getText() == "" && (relleno == false)) {
                        button6.setText("X");
                        relleno = true;
                        button6.setBackgroundColor(Color.GREEN);
                        juegaMaquina();
                        comprobar();
                    }
                }
            });

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button7.getText() == "" && (relleno == false)) {
                        button7.setText("X");
                        relleno = true;
                        button7.setBackgroundColor(Color.GREEN);
                        juegaMaquina();
                        comprobar();
                    }
                }
            });

            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button8.getText() == "" && (relleno == false)) {
                        button8.setText("X");
                        relleno = true;
                        button8.setBackgroundColor(Color.GREEN);
                        juegaMaquina();
                        comprobar();
                    }
                }
            });
            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button9.getText() == "" && (relleno == false)) {
                        button9.setText("X");
                        relleno = true;
                        button9.setBackgroundColor(Color.GREEN);
                        juegaMaquina();
                        comprobar();
                    }
                }
            });
        } while (relleno == false);
    }


    public void juegaMaquina() {
        do {
            int aleatorio = (int) (9 * Math.random() + 1);

            if (aleatorio == 1 && (relleno2 == false)) {
                if (button1.getText() == "") {
                    button1.setText("O");
                    relleno2 = true;
                    button1.setBackgroundColor(Color.RED);
                }
            } else if (aleatorio == 2 && (relleno == false)) {
                if (button2.getText() == "") {
                    button2.setText("O");
                    relleno2 = true;
                    button2.setBackgroundColor(Color.RED);
                }
            } else if (aleatorio == 3 && (relleno == false)) {
                if (button3.getText() == "") {
                    button3.setText("O");
                    relleno2 = true;
                    button3.setBackgroundColor(Color.RED);
                }
            } else if (aleatorio == 4 && (relleno == false)) {
                if (button4.getText() == "") {
                    button4.setText("O");
                    relleno2 = true;
                    button4.setBackgroundColor(Color.RED);
                }
            } else if (aleatorio == 5 && (relleno == false)) {
                if (button5.getText() == "") {
                    button5.setText("O");
                    relleno2 = true;
                    button5.setBackgroundColor(Color.RED);
                }
            } else if (aleatorio == 6 && (relleno == false)) {
                if (button6.getText() == "") {
                    button6.setText("O");
                    relleno2 = true;
                    button6.setBackgroundColor(Color.RED);
                }
            } else if (aleatorio == 7 && (relleno == false)) {
                if (button7.getText() == "") {
                    button7.setText("O");
                    relleno2 = true;
                    button7.setBackgroundColor(Color.RED);
                }
            } else if (aleatorio == 8 && (relleno == false)) {
                if (button8.getText() == "") {
                    button8.setText("O");
                    relleno2 = true;
                    button8.setBackgroundColor(Color.RED);
                }
            } else if (aleatorio == 9 && (relleno == false)) {
                if (button9.getText() == "") {
                    button9.setText("O");
                    relleno2 = true;
                    button9.setBackgroundColor(Color.RED);
                }
            }
        } while (relleno2 == false);
    }

    public void comprobar() {
        if (button1.getText() == "X" && button2.getText() == "X" && button3.getText() == "X") {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            Toast.makeText(getBaseContext(), "Has ganado", Toast.LENGTH_SHORT).show();

        } else if (button1.getText() == "X" && button5.getText() == "X" && button9.getText() == "X") {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            Toast.makeText(getBaseContext(), "Has ganado", Toast.LENGTH_SHORT).show();

        } else if (button1.getText() == "X" && button4.getText() == "X" && button7.getText() == "X") {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            Toast.makeText(getBaseContext(), "Has ganado", Toast.LENGTH_SHORT).show();

        } else if (button2.getText() == "X" && button5.getText() == "X" && button8.getText() == "X") {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            Toast.makeText(getBaseContext(), "Has ganado", Toast.LENGTH_SHORT).show();

        } else if (button3.getText() == "X" && button6.getText() == "X" && button9.getText() == "X") {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            Toast.makeText(getBaseContext(), "Has ganado", Toast.LENGTH_SHORT).show();

        } else if (button1.getText() == "O" && button2.getText() == "O" && button3.getText() == "O") {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            Toast.makeText(getBaseContext(), "Has perdido", Toast.LENGTH_SHORT).show();

        } else if (button1.getText() == "O" && button5.getText() == "O" && button9.getText() == "O") {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            Toast.makeText(getBaseContext(), "Has perdido", Toast.LENGTH_SHORT).show();

        } else if (button1.getText() == "O" && button4.getText() == "O" && button7.getText() == "O") {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            Toast.makeText(getBaseContext(), "Has perdido", Toast.LENGTH_SHORT).show();

        } else if (button2.getText() == "O" && button5.getText() == "O" && button8.getText() == "O") {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            Toast.makeText(getBaseContext(), "Has perdido", Toast.LENGTH_SHORT).show();

        } else if (button3.getText() == "O" && button6.getText() == "O" && button9.getText() == "O") {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            Toast.makeText(getBaseContext(), "Has perdido", Toast.LENGTH_SHORT).show();

        }
    }
}