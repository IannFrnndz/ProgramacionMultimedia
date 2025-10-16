package com.example.calculadora_ian;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        Log.i("LifeCycle","onPause");
        //Button b = findViewById(R.id.buttonHola);

        //b.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {

            //}
        //});
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("LifeCycle","onStart");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("LifeCycle","onRestart");
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("LifeCycle","onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("LifeCycle","onStop");
    }

    @Override
    protected void onPostResume(){
        super.onPostResume();
    }
}