package com.example.ej2listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> lista;
    private ArrayAdapter<String> adaptador;
    private ListView lv1;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<String>();
        lista.add("David: 654125987");
        lista.add("Nicolas: 698523695");
        lista.add("Eva: 852152368");
        lista.add("Jose: 852362014");
        lista.add("Samu: 210326974");
        lista.add("Norberto: 236410258");

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        lv1.setAdapter(adaptador);


    }

    public void agregar(View view) {


    }
}