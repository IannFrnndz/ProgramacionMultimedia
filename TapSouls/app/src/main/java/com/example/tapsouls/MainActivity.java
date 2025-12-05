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

    // assign an initial value to the improvement cost
    private int costoMejora = 20;

    // each improvement cost will be multiplied by 4
    private double multiCosto = 4.0;
    private TextView textView;

    Button buttonMejorarVariable;
    ImageView imageViewCookie;
    ImageView imageViewEmerald;

    TextView nombreUsuario;

    private int mejorar;

    private int contador = 0;

    // level simulator in order to change the upgrading  picture
    private int nivel = 1;
    public void cambiarImagenDeMejora() {

        if (nivel >= 1 && nivel <= 3) {
            imageViewEmerald.setImageResource(R.drawable.coal);

        } else if (nivel >= 4 && nivel <= 6) {
            imageViewEmerald.setImageResource(R.drawable.iron);

        } else if (nivel >= 7 && nivel <= 9) {
            imageViewEmerald.setImageResource(R.drawable.gold);

        } else {
            imageViewEmerald.setImageResource(R.drawable.diamond);
        }
    }




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


        // variableQueGuardaUnBoton = findViewById(R.id.button);
        // buttonMejorarVariable = findViewById(R.id.buttonMejorar);
        loQueCuestaMejorar = findViewById(R.id.textViewMejorar);
        imageViewCookie = findViewById(R.id.imageViewCookie);
        imageViewEmerald = findViewById(R.id.imageViewEmerald);

        TextView textViewUsuario = findViewById(R.id.textViewUsuario);


        textView = findViewById(R.id.textView);


        textView.setText("Numero de galletas: " + "0");
        loQueCuestaMejorar.setText("Mejorar cuesta: 20 galletas");

        textViewUsuario.setText("Jugador: " + nombreUsuario);


        imageViewCookie.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                contador += incrementoPorClick;
                textView.setText("Numero de galletas: " + contador);

            }
        });




        imageViewEmerald.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contador < costoMejora){
                    Toast.makeText(MainActivity.this, "No tienes suficientes galletas. Necesitas: " + costoMejora, Toast.LENGTH_SHORT).show();
                } else {
                    // if the player has enough cookies, subtract the upgrade cost
                    contador -= costoMejora;

                    // each click becomes twice as strong
                    incrementoPorClick *= 2;

                    // increase the improvement cost so it isn’t too easy
                    costoMejora *= multiCosto;

                    nivel++;  // We upgrade the level

                    // verify whether we have to change the picture
                    cambiarImagenDeMejora();

                    textView.setText("Numero de galletas: " + contador);
                    // show how much is needed for the next improvement
                    loQueCuestaMejorar.setText("Mejorar cuesta: " + costoMejora + " galletas");

                    // notify the user that the upgrade was successful
                    Toast.makeText(MainActivity.this, "NIVEL: "+ nivel + " Cada click ahora da " + incrementoPorClick + ". Proxima mejora: " + costoMejora + " galletas.", Toast.LENGTH_SHORT).show();




                }
            }
        });
    }



}
