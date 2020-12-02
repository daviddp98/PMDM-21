package com.example.daviddpex2ev1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

class MiAdaptador extends ArrayAdapter<Lista_entrada> {
    Context ctx;
    int layoutTemplate;
    List<Lista_entrada> list;

    public MiAdaptador(@NonNull Context context, @LayoutRes int resource, @NonNull List<Lista_entrada> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        // Obtener la información del elemento de la lista que estoy iterando en este momento
        Lista_entrada elementoActual = list.get(position);

        // Rescatar los elementos de la IU de la template
        TextView textViewTitulo = (TextView) v.findViewById(R.id.textViewTitulo);
        TextView textViewModelo = (TextView) v.findViewById(R.id.textView);
        ImageView imageViewFoto = (ImageView) v.findViewById(R.id.imageViewFoto);

        // Hacer un set de la info del elemento Actual en los elementos de la IU
        textViewTitulo.setText(elementoActual.get_textoEncima());
        textViewModelo.setText(elementoActual.get_textoDebajo());
        //imageViewFoto.setImageResource();

        return v;
    }
}
