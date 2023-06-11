package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        TextView result = findViewById(R.id.result);
        Button add = findViewById(R.id.sum_button);

        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String str_num1 = num1.getText().toString();
                String str_num2 = num2.getText().toString();

                int int_result = Integer.parseInt(str_num1) + Integer.parseInt(str_num2);

                result.setText("Answer = " + int_result);
            }
        });
    }
}