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

    EditText editTextApellido;

    Button buttonIniciarSesion;

    ImageView imageViewStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // escondemos la barra superior con el nombre de la actividad
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

        editTextApellido = findViewById(R.id.editTextApellido);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextContrasena = findViewById(R.id.editTextContrasena);
        //buttonIniciarSesion = findViewById(R.id.buttonInicioSesion);

        imageViewStart = findViewById(R.id.imageViewStart);

        imageViewStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = editTextNombre.getText().toString();
                String contrasena = editTextContrasena.getText().toString();
                String apellido = editTextApellido.getText().toString();

                // creamos una simulacion de inicio de sesion
                if(nombre.isEmpty() && contrasena.isEmpty() && apellido.isEmpty() ) {
                    Toast.makeText(LoginActivity.this, "Usuario, apellido o contraseña incorrecta", Toast.LENGTH_SHORT).show();

                } else {

                    // Abrir MainActivity y pasar nombre de usuario
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    // utilizamos el intent put extra para enviar el nombre al main activity
                    intent.putExtra("Nombre", nombre);
                    intent.putExtra("Apellido", apellido);


                    startActivity(intent);

                    // evitamos que al volver atras nos vuelva al login
                    finish();
                }

            }

    });

    }

}