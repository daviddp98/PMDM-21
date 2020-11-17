package com.example.ej2listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> lista;
    private ArrayAdapter<String> adaptador;
    private ListView listView;
    private EditText editText;

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

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adaptador);

        editText = (EditText) findViewById(R.id.editText);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion = i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
                dialogo1.setTitle("Borrar");
                dialogo1.setMessage("¿Borrar este contacto?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        lista.remove(posicion);
                        adaptador.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });
    }

    public void agregar(View v) {
        lista.add(editText.getText().toString());
        adaptador.notifyDataSetChanged();
        editText.setText("");
    }
}