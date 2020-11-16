package com.example.ejlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listv;
    ArrayList<Persona> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listv = (ListView) findViewById(R.id.listv);

        nombres = new ArrayList<Persona>();
        nombres.add(new Persona("David", 'H'));
        nombres.add(new Persona("Maria", 'M'));
        nombres.add(new Persona("Pedro", 'H'));
        nombres.add(new Persona("Mario", 'H'));
        nombres.add(new Persona("Marta", 'M'));
        nombres.add(new Persona("Eva", 'M'));
        nombres.add(new Persona("Alberto", 'H'));

        ArrayAdapter<Persona> adapter = new ArrayAdapter<Persona>(this, android.R.layout.simple_list_item_1, nombres);
        listv.setAdapter(adapter);

        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                

            }
        });
    }
}