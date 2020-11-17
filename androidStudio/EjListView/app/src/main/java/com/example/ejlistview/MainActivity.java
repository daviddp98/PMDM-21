package com.example.ejlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Persona> listapersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listapersonas=new ArrayList<Persona>();
        listapersonas.add(new Persona("David", 'H'));
        listapersonas.add(new Persona("Juan",'H'));
        listapersonas.add(new Persona("Luis",'H'));
        listapersonas.add(new Persona("Ana",'M'));
        listapersonas.add(new Persona("Maria",'M'));

        AdaptadorPersonas adaptador = new AdaptadorPersonas(this);
        ListView lv1 = (ListView)findViewById(R.id.listv);
        lv1.setAdapter(adaptador);
    }

    class AdaptadorPersonas extends ArrayAdapter<Persona> {

        AppCompatActivity appCompatActivity;

        AdaptadorPersonas(AppCompatActivity context) {
            super(context, R.layout.activity_main, listapersonas);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_main, null);

            TextView textView1 = (TextView)item.findViewById(R.id.textView);
            textView1.setText(listapersonas.get(position).getNombre());

            ImageView imageView1 = (ImageView)item.findViewById(R.id.imageView);
            if (listapersonas.get(position).getGenero()=='H')
                imageView1.setImageResource(R.drawable.hombre);
            else
                imageView1.setImageResource(R.drawable.mujer);
            return(item);
        }
    }
}