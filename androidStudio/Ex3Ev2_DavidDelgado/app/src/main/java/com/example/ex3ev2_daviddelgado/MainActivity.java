package com.example.ex3ev2_daviddelgado;

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
    List<Lugar> listalugares;

    ArrayAdapter<Lugar> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        listalugares = new ArrayList<>();
        listalugares.add(new Lugar("Museo de Bellas Artes de Sevilla", 37.392646943707796, -5.999914383771823));
        listalugares.add(new Lugar("MoMa de Nueva York", 40.76165209156912, -73.97766451810115));
        listalugares.add(new Lugar("Museo Van Gogh", 52.358494507493525, 4.881665683760765));
        listalugares.add(new Lugar("Museo del Louvre", 48.86073813082154, 2.3381160663922986));

        adaptador = new ArrayAdapter<Lugar>(this, android.R.layout.simple_list_item_1, listalugares);

        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("nombre", listalugares.get(position).getNombre());
        intent.putExtra("latitud", listalugares.get(position).getLatitud());
        intent.putExtra("longitud", listalugares.get(position).getLongitud());

        startActivity(intent);
    }
}