package com.example.ejemploclasehilos;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private Button variable_que_guarada_un_boton;

    private TextView textito;
    private final Handler handler_guapo = new Handler(Looper.getMainLooper());


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
        textito = findViewById(R.id.textView);
        variable_que_guarada_un_boton = findViewById(R.id.buttonGuapardo);

        variable_que_guarada_un_boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MiHiloPausa().start();
            }
        });
    }

    class MiHiloPausa extends Thread
    {

        @Override
        public void run() {
            super.run();

            for(int i = 0; i <= 100; i++)
            {
                int value = i;
                handler_guapo.post(()-> textito.setText("Contador : " + value));
                try{
                    Thread.sleep(1000);
                    /*new Handler(Looper.getMainLooper()).post(()->
                            Toast.makeText(MainActivity.this, "TERMINÉ EL SLEEEP", Toast.LENGTH_LONG).show()
                    );*/

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }


        }


    }
}