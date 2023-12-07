package com.example.tranluudongtrieu_2011064067_baitapcanhantuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText email = findViewById(R.id.edtEmail);
        TextInputLayout errorEmail = findViewById(R.id.errorEmail);
        EditText password = findViewById(R.id.edtPass);
        TextInputLayout errorPassword = findViewById(R.id.errorPass);
        Button btnLogin = findViewById(R.id.btnLogin);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String emailSignup = bundle.getString("emailSignup");
        String passSignup = bundle.getString("passSignup");


        btnLogin.setOnClickListener(v -> {
            if(email.getText().toString().equals(emailSignup) && password.getText().toString().equals(passSignup)){
                Intent intentMain = new Intent(this, MainActivity.class);
                startActivity(intentMain);
            }
        });



    }
}