package com.example.proyecto_startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Estas variables las declaramos al principio de nuestra clase, justo debajo
// de la cabecera:
    private final static int NOMBRE = 0;
    private final static int APELLIDO = 1;
    EditText etNombre, etApellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellido = (EditText)findViewById(R.id.etApellido);
    }

    // Método que se ejecuta al pulsar el botón btNombre:
    public void rellenarNombre(View v) {
        Intent i = new Intent(this, RellenarCampos.class);
        // Iniciamos la segunda actividad, y le indicamos que la iniciamos
        // para rellenar el nombre:
        startActivityForResult(i, NOMBRE);
    }
    // Método que se ejecuta al pulsar el botón btApellido
    public void rellenarApellido(View v) {
        Intent i = new Intent(this, RellenarCampos.class);
        // Iniciamos la segunda actividad, y le indicamos que la iniciamos
        // para rellenar el apellido:
        startActivityForResult(i, APELLIDO);
    }

    // Este método nos trae la información de para qué se llamó la segunda actividad,
// cuál fue el resultado ("OK" o "CANCELED"), y el intent que nos traerá la
// información que necesitamos de la segunda actividad.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Comprobamos si el resultado de la segunda actividad es "RESULT_CANCELED".
        if (resultCode == RESULT_CANCELED) {
            // Si es así mostramos mensaje de cancelado por pantalla.
            Toast.makeText(this, "Resultado cancelado", Toast.LENGTH_SHORT)
                    .show();
        } else {
            // De lo contrario, recogemos el resultado de la segunda actividad.
            String resultado = data.getExtras().getString("RESULTADO");
            // Y tratamos el resultado en función de si se lanzó para rellenar el
            // nombre o el apellido.
            switch (requestCode) {
                case NOMBRE:
                    etNombre.setText(resultado);
                    break;
                case APELLIDO:
                    etApellido.setText(resultado);
                    break;
            }
        }
    }
}