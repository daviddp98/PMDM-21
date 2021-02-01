package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a6_almacenamiento_usuarioycontrasena.R;

public class LoginActivity extends AppCompatActivity {

    EditText editTextTextPersonName;
    EditText editTextTextPassword;
    TextView textView;
    TextView textView2;
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_activity_file), Context.MODE_PRIVATE);
        boolean isLogin = sharedPref.getBoolean(getString(R.string.preferencias_islogin), false);

        if (isLogin) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

    public void doLogin(View view) {
        String email = editTextTextPersonName.getText().toString();
        String pass = editTextTextPassword.getText().toString();

        if (email.equals("daviddp98@gmail.com") && pass.equals("1234")) {
            // Login correcto

            // Guardar los datos del login
            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_activity_file), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(getString(R.string.preferencias_email), email);
            editor.putBoolean(getString(R.string.preferencias_islogin), true);
            editor.commit();

            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);

        } else {
            Toast.makeText(this, "Email y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}