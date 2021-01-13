package com.example.daviddelgadoex1ev2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDetalle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDetalle extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    public void mostrarDetalle(String texto) {

        TextView txtDetalle = (TextView) getView().findViewById(R.id.TxtDetalle);
        txtDetalle.setText(texto);
    }
}