package com.example.calculadora_ian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView pantalla;
    private StringBuilder operacion = new StringBuilder();

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

        pantalla = findViewById(R.id.respuestaCalculadora);

        int[] botonesIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9, R.id.buttonMas, R.id.buttonMenos,
                R.id.buttonDividir, R.id.buttonPunto, R.id.buttonIgual,
                R.id.buttonC
        };

        for (int id : botonesIds) {
            Button b = findViewById(id);
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String textoBoton = b.getText().toString();

        switch (textoBoton) {
            case "C":
                operacion.setLength(0);
                pantalla.setText("Ingrese una operación...");
                break;
            case "=":
                calcularResultado();
                break;
            default:
                if (pantalla.getText().toString().equals("Ingrese una operación...")) {
                    pantalla.setText("");
                }
                operacion.append(textoBoton);
                pantalla.setText(operacion.toString());
                break;
        }
    }

    private void calcularResultado() {
        try {
            String expr = operacion.toString();
            double resultado = evaluar(expr);
            pantalla.setText(String.valueOf(resultado));
            operacion.setLength(0);
            operacion.append(resultado);
        } catch (Exception e) {
            pantalla.setText("Error");
            operacion.setLength(0);
        }
    }

    // Evaluador de expresiones básicas sin librerías
    private double evaluar(String expr) {
        // Eliminar espacios
        expr = expr.replace(" ", "");

        // Buscar operador principal (+, -, *, /)
        if (expr.contains("+")) {
            String[] parts = expr.split("\\+");
            return evaluar(parts[0]) + evaluar(parts[1]);
        } else if (expr.contains("-")) {
            // evitar problema con números negativos
            int idx = expr.lastIndexOf("-");
            if (idx > 0) {
                String left = expr.substring(0, idx);
                String right = expr.substring(idx + 1);
                return evaluar(left) - evaluar(right);
            }
        } else if (expr.contains("*")) {
            String[] parts = expr.split("\\*");
            return evaluar(parts[0]) * evaluar(parts[1]);
        } else if (expr.contains("/")) {
            String[] parts = expr.split("/");
            double divisor = evaluar(parts[1]);
            if (divisor == 0) throw new ArithmeticException();
            return evaluar(parts[0]) / divisor;
        }

        // Si no hay operador, devolver número
        return Double.parseDouble(expr);
    }
}
