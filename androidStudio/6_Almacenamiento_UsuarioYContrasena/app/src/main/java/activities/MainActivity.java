package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.a6_almacenamiento_usuarioycontrasena.R;

public class MainActivity extends AppCompatActivity {

    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView4 = findViewById(R.id.textView4);
    }
}