package com.example.tapsouls;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button variableQueGuardaUnBoton;
    private TextView textView;

    Button buttonMejorarVariable;

    private int mejorar;

    private int  contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        variableQueGuardaUnBoton = findViewById(R.id.button);
        buttonMejorarVariable = findViewById(R.id.buttonMejorar);



        textView = findViewById(R.id.textView);


        textView.setText("Numero de galletas: " + "0");

        variableQueGuardaUnBoton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                contador++;
                textView.setText("Numero de galletas: "+ contador);

            }
        });


        buttonMejorarVariable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mejorar = contador - 20;
                textView.setText("Numero de galletas: "+ mejorar);
            }
        });
    }




}