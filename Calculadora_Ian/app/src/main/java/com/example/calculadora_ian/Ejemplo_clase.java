package com.example.calculadora_ian;

import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

public class Ejemplo_clase extends FragmentActivity implements ToolbarFragment.ToolbarListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejemplo_clase);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       /* Button b = findViewById(R.id.button);

        TextView t3 = findViewById(R.id.textView3);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t3.setText("On Click");
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                t3.setText("Long Click");
                return false;
            }
        });
        TextView t2 = findViewById(R.id.textView2);
        ConstraintLayout m = findViewById(R.id.main);
        m.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                t2.setText("On touch");
                return true;
            }
        });
*/


    }

    @Override
    public void onButtonClick(int size, String text) {
        TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.TextFContainer);

        if (textFragment != null){
            textFragment.ChangeTextProperties(size, text);
        }
    }


    /*
    public void HandleTouchEvent(View v, MotionEvent me){
        TextView t4 = findViewById(R.id.textView4);
        TextView t1 = findViewById(R.id.textView);

        int pointerCount = me.getPointerCount();
        for (int i = 0; i < pointerCount; i++){
            int x = (int) me.getX();
            int y = (int) me.getX();

            int id = me.getPointerId(i);
            int action = me.getActionMasked();
            int actionIndex = me.getActionIndex();

            String actionName;

            switch (action){
                case MotionEvent.ACTION_UP:
                    actionName = "UP";
                    break;
                case MotionEvent.ACTION_DOWN:
                    actionName = "Down";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionName = "PTR_UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionName = "PTR_DOWN";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionName = "MOVE";
                    break;
                default:
                    actionName = "";
                    break;
            }

            String touchStatus = "Action: " + actionName + " Index: " + actionIndex + " ID: " + id + " X: " + x + " Y: " + y;

            if(id == 0)
            {
                t1.setText(touchStatus);
            }
            else
            {
                t4.setText(touchStatus);
            }

        }


        }*/
    }
