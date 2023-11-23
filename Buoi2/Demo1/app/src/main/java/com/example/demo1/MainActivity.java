package com.example.demo1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.idTxt);
        editText.setText(editText.getText().toString()+"onCreate") ;

        Button button = findViewById(R.id.idBtn);
        button.setOnClickListener(v -> {

            showDialog(v);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    openIntent(v);
                }
            }, 1000);
        });
        EditText error = findViewById(R.id.idTxt2);
        error.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.length() == 0){
                    error.setError("Không được để trống!");
                }
                else
                    error.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText email = findViewById(R.id.idTxt3);
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!isValidEmail(s.toString())){
                    email.setError("Sai dinh dang Email");
                }
                else
                    email.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        EditText editText = findViewById(R.id.idTxt);
        editText.setText(editText.getText().toString()+"onStart") ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        EditText editText = findViewById(R.id.idTxt);
        editText.setText(editText.getText().toString()+"onPause") ;
    }

    @Override
    protected void onPause() {
        super.onPause();
        EditText editText = findViewById(R.id.idTxt);
        editText.setText(editText.getText().toString()+"onPause") ;
    }

    @Override
    protected void onStop() {
        super.onStop();
        EditText editText = findViewById(R.id.idTxt);
        editText.setText(editText.getText().toString()+"onStop") ;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        EditText editText = findViewById(R.id.idTxt);
        editText.setText(editText.getText().toString()+"onRestart") ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EditText editText = findViewById(R.id.idTxt);
        editText.setText(editText.getText().toString()+"onDestroy") ;
    }

    public void showDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert!");
        builder.setMessage("Dang chuyen den Main 2");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void openIntent(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}