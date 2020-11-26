package com.example.widgetsseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//Crear un array con los elementos seleccionables
        String[] elementos = {"Toledo", "Ciudad Real", "Cuenca", "Guadalajara", "Albacete"};

//Declaras un adaptador de Texto (String)
        ArrayAdapter<String> adaptador;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Obtienes una referencia a la lista
        ListView l = (ListView) findViewById(R.id.listView);

//Creas el adaptador
        adaptador = new ArrayAdapter<String>(this, R.layout.fila, elementos);

//Le das el adaptador a la lista
        l.setAdapter(adaptador);
    }

    public class MyActivity extends Activity implements ListView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView t = (TextView) findViewById(R.id.textView);
            t.setText("Has elegido: " + parent.getItemAtPosition(position).toString());
        }
    }
}