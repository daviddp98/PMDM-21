package com.example.daviddelgadoex2ev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements OnNuevoContactoListener, OnEliminarContactoListener {

    DialogFragment dialogoNuevoContacto, dialogoEliminarContacto;
    Button btnAñadir, btnEliminar;
    ListView listView;

    ArrayList<Contacto> contactos;
    ArrayAdapter<Contacto> adaptador1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<>();
        adaptador1 = new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, contactos);

        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adaptador1);

        btnAñadir = (Button) findViewById(R.id.btnAñadir);
        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoNuevoContacto = new NuevoContactoFragment();
                dialogoNuevoContacto.show(getSupportFragmentManager(), "NuevoContactoFragment");
            }
        });

        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoEliminarContacto = new EliminarContactoFragment();
                dialogoEliminarContacto.show(getSupportFragmentManager(), "EliminarContactoFragment");
            }
        });

        leerSharedPreferences();
    }

    @Override
    public void onContactoGuardarClickListener(View v) {
        Toast.makeText(this, "Se ha recibido el contacto guardado", Toast.LENGTH_SHORT).show();
        EditText nom = v.findViewById(R.id.editText);
        EditText num = v.findViewById(R.id.editText2);

        String nombre = nom.getText().toString();
        String numero = num.getText().toString();

        contactos.add(new Contacto(nombre, numero));
        adaptador1 = new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, contactos);
        listView.setAdapter(adaptador1);

        guardarSharedPreferences();
    }

    @Override
    public void onContactoEliminarClickListener(View v) {
        Toast.makeText(this, "Se ha eliminado el contacto", Toast.LENGTH_SHORT).show();
        EditText nom = v.findViewById(R.id.editText);
        EditText num = v.findViewById(R.id.editText2);

        String nombre = nom.getText().toString();
        String numero = num.getText().toString();

        for (int i = 0; i < contactos.size(); i++) {
            if (nombre.equalsIgnoreCase(contactos.get(i).getNombre()) && numero.equalsIgnoreCase(contactos.get(i).getTelef())) {
                contactos.remove(i);
            }
        }
        adaptador1 = new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, contactos);
        listView.setAdapter(adaptador1);

        guardarSharedPreferences();
    }

    private void guardarSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("PrefenciasActivity", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Set<String> nombres = new HashSet<>(), numeros = new HashSet<>();

        for (int i = 0; i < contactos.size(); i++) {
            nombres.add(contactos.get(i).getNombre());
            numeros.add(contactos.get(i).getTelef());
        }
        editor.putStringSet("nombre", nombres);
        editor.putStringSet("telefono", numeros);
        editor.apply();
    }

    private void leerSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("PrefenciasActivity", MODE_PRIVATE);
        Set<String> nombres = new HashSet<>(), numeros = new HashSet<>();

        nombres = sharedPreferences.getStringSet("nombre", null);
        numeros = sharedPreferences.getStringSet("telefono", null);

        ArrayList<String> noms = new ArrayList<>(nombres), nums = new ArrayList<>(numeros);
        contactos = new ArrayList<>();
        for (int i = 0; i < noms.size(); i++) {
            contactos.add(new Contacto(noms.get(i), nums.get(i)));
        }

        adaptador1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contactos);
        listView.setAdapter(adaptador1);
    }
}