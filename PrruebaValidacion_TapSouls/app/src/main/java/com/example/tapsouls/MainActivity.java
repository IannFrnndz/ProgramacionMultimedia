package com.example.tapsouls;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button variableQueGuardaUnBoton;

    TextView loQueCuestaMejorar;

    private int incrementoPorClick = 1;

    // asignamos un valor a lo que cuesta mejorar en un inicio
    private int costoMejora = 20;

    // cada costo de mejora se va a multiplicar por 4
    private double multiCosto = 4.0;
    private TextView textView;

    Button buttonMejorarVariable;
    ImageView imageViewCookie;

    TextView nombreUsuario;

    private int mejorar;

    private int  contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        String nombreUsuario = getIntent().getStringExtra("Nombre");
        String apellido = getIntent().getStringExtra("Apellido");


        //variableQueGuardaUnBoton = findViewById(R.id.button);
        buttonMejorarVariable = findViewById(R.id.buttonMejorar);
        loQueCuestaMejorar = findViewById(R.id.textViewMejorar);
        imageViewCookie = findViewById(R.id.imageViewCookie);

        TextView textViewUsuario = findViewById(R.id.textViewUsuario);




        textView = findViewById(R.id.textView);




        textView.setText("Numero de galletas: " + "0");
        loQueCuestaMejorar.setText("Mejorar cuesta: 20 galletas");

        textViewUsuario.setText("Jugador: " + nombreUsuario + "\nApellido: " + apellido);


        imageViewCookie.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                contador += incrementoPorClick;
                textView.setText("Numero de galletas: "+ contador);

            }
        });


        buttonMejorarVariable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contador < costoMejora){
                    Toast.makeText(MainActivity.this, "No tienes suficientes galletas. Necesitas: " + costoMejora, Toast.LENGTH_SHORT).show();
                } else {
                    // si tiene suficiente restamos el numero de galletas que tiene por lo que cuesta la mejora
                    contador -= costoMejora;

                    // hacemos que cada click ahora sea el doble
                    incrementoPorClick *= 2;

                    // incrementamos el valor del costo para que no sea tan facil
                    costoMejora *= multiCosto;


                    textView.setText("Numero de galletas: " + contador);
                    // mostramos cuanto se necesita para mejorar
                    loQueCuestaMejorar.setText("Mejorar cuesta: "+ costoMejora + " galletas");

                    // aviso cuando mejoramos para que el usuario sepa que es lo que ha hecho
                    Toast.makeText(MainActivity.this, " Cada click ahora suma " + incrementoPorClick + ". Próxima mejora: " + costoMejora + " galletas.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}