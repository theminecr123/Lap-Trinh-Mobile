package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edtText);
        Button button = findViewById(R.id.btnChange);
        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            FragmentA fragmentA = (FragmentA) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
            if(text.length() !=0){
                fragmentA.editText(text);
            }else{
                Toast.makeText(getApplicationContext(),"Vui lòng nhập!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}