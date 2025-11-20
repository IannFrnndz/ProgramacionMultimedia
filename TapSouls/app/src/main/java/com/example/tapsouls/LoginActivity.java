package com.example.tapsouls;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText editTextNombre;
    EditText editTextContrasena;

    Button buttonIniciarSesion;

    ImageView imageViewStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageViewStart = findViewById(R.id.imageViewStart);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextContrasena = findViewById(R.id.editTextContrasena);
        // buttonIniciarSesion = findViewById(R.id.buttonInicioSesion);

        imageViewStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = editTextNombre.getText().toString();
                String contrasena = editTextContrasena.getText().toString();

                // create a login simulation
                if(nombre.isEmpty() && contrasena.isEmpty() ) {
                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();

                } else {

                    // Open MainActivity and pass the username
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    // use intent putExtra to send the username to MainActivity
                    intent.putExtra("Nombre", nombre);

                    startActivity(intent);

                    // prevent returning to the login screen when pressing back
                    finish();
                }

            }

        });

    }

}
