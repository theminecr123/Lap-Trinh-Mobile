package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btnSubmit);
        edt = findViewById(R.id.edtInput);
        btn.setOnClickListener(v -> {
            FragmentBlank fragment = (FragmentBlank) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView4);
            if(fragment != null){
                fragment.setImage(edt.getText().toString());
            }
        });
    }
}