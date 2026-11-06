package com.example.cr7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    TextView result;

    Button btnAdd, btnSubtract;
    Button btnMultiply, btnDivide, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnClear = findViewById(R.id.btnClear);

        btnAdd.setOnClickListener(v -> calculate("+"));

        btnSubtract.setOnClickListener(v -> calculate("-"));

        btnMultiply.setOnClickListener(v -> calculate("*"));

        btnDivide.setOnClickListener(v -> calculate("/"));

        btnClear.setOnClickListener(v -> {
            number1.setText("");
            number2.setText("");
            result.setText("نتیجه: ");
        });
    }

    private void calculate(String operation) {

        String first = number1.getText().toString().trim();
        String second = number2.getText().toString().trim();

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(this,
                    "لطفاً هر دو عدد را وارد کنید",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(first);
        double b = Double.parseDouble(second);

        double answer = 0;

        switch (operation) {

            case "+":
                answer = a + b;
                break;

            case "-":
                answer = a - b;
                break;

            case "*":
                answer = a * b;
                break;

            case "/":
                if (b == 0) {
                    result.setText("تقسیم بر صفر امکان‌پذیر نیست");
                    return;
                }
                answer = a / b;
                break;
        }

        result.setText(getString(
                R.string.result_format,
                String.valueOf(answer)
        ));
    }
}