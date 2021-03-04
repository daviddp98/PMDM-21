package com.example.listview_maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    List<Mapa> listmapas;

    ArrayAdapter<Mapa> adaptador1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        listmapas = new ArrayList<>();
        listmapas.add(new Mapa("Sevilla", 37.38283, -5.97317));
        listmapas.add(new Mapa("Alcolea del Río", 37.61506, -5.66694));
        listmapas.add(new Mapa("Madrid", 40.4165, -3.70256));
        listmapas.add(new Mapa("Cataluña", 41.38879, 2.15899));

        adaptador1 = new ArrayAdapter<Mapa>(this, android.R.layout.simple_list_item_1, listmapas);

        listView.setAdapter(adaptador1);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("nombre", listmapas.get(position).getNombre());
        intent.putExtra("latitud", listmapas.get(position).getLatitud());
        intent.putExtra("longitud", listmapas.get(position).getLongitud());

        startActivity(intent);
    }
}