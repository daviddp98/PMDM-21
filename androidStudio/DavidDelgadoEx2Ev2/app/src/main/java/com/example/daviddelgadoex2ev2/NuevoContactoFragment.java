package com.example.daviddelgadoex2ev2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class NuevoContactoFragment extends DialogFragment {

    AlertDialog.Builder builder;
    OnNuevoContactoListener mListener;
    View v;
    EditText editText, editText2;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //builder.setView(inflater.inflate(R.layout.fragment_nuevo_contacto, null));
        v = inflater.inflate(R.layout.fragment_nuevo_contacto, null);
        builder.setView(v);
        editText = (EditText) v.findViewById(R.id.editText);
        editText2 = (EditText) v.findViewById(R.id.editText2);

        builder.setTitle("Nuevo Contacto")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Contacto Guardado", Toast.LENGTH_SHORT).show();
                        mListener.onContactoGuardarClickListener(v);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cancelar > cerrar el cuadro de diálogo
                        dialog.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (OnNuevoContactoListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement OnNuevoContactoListener");
        }
    }
}