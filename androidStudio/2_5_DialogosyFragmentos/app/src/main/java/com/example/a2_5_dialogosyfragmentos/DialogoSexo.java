package com.example.a2_5_dialogosyfragmentos;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class DialogoSexo extends DialogFragment {

    RespuestaDialogoSexo respuesta;

    //Este método es llamado al hacer el show() de la clase DialogFragment()
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

// Usamos la clase Builder para construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//Escribimos el título
        builder.setTitle("Pregunta muy importante:");
//Escribimos la pregunta
        builder.setMessage("¿Eres una chica?");
//añadimos el botón de Si y su acción asociada
        builder.setPositiveButton("¡SI!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                respuesta.onRespuesta("Es una chica!");
            }
        });
//añadimos el botón de No y su acción asociada
        builder.setNegativeButton("¡NO!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                respuesta.onRespuesta("Es un chico!");
            }
        });
// Crear el AlertDialog y devolverlo
        return builder.create();
    }

    //interfaz para la comunicación entre la Actividad y el Fragmento
    public interface RespuestaDialogoSexo {
        public void onRespuesta(String s);
    }

    //Se invoca cuando el fragmento se añade a la actividad
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        respuesta = (RespuestaDialogoSexo) activity;
    }
}