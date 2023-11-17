package com.example.bai1_buoi1;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi = editText.getText().toString();
                int doDai = chuoi.replaceAll("\\s+","").trim().length();
                textView.setText("Độ dài của chuỗi là: " + doDai);
            }
        });
    }
}