package com.example.tranluudongtrieu_2011064067_baitapcanhantuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivtity extends AppCompatActivity {


    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activtity);
        EditText username = findViewById(R.id.edtName);
        TextInputLayout errorName = findViewById(R.id.errorUsername);

        EditText email = findViewById(R.id.edtEmail);
        TextInputLayout errorEmail = findViewById(R.id.errorEmail);
        EditText password = findViewById(R.id.edtPass);
        TextInputLayout errorPassword = findViewById(R.id.errorPass);

        EditText confirmPassword = findViewById(R.id.edtConfirmPass);
        TextInputLayout errorConfirm = findViewById(R.id.errorConfirmPass);

        final Boolean[] isValid = {false};
    Button signup = findViewById(R.id.btnSignup);
    TextView toLogin = findViewById(R.id.txtToLogin);
    email.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(TextUtils.isEmpty(s)){
                errorEmail.setError("Email không được để trống!");
                isValid[0] = false;

            }
            else {
                errorEmail.setError(null);

            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(!isValidEmail(s.toString())){
                errorEmail.setError("Email không đúng định dạng!");
                isValid[0] = false;

            }else {
                errorEmail.setError(null);

            }
        }
    });

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(TextUtils.isEmpty(charSequence)){
                    errorName.setError("Không được để trống!");
                    isValid[0] = false;

                }else {
                    errorName.setError(null);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(TextUtils.isEmpty(charSequence)){
                    errorPassword.setError("Password không được để trống!");
                    isValid[0] = false;

                }
                else {
                    errorPassword.setError(null);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(TextUtils.isEmpty(charSequence)){
                    errorConfirm.setError("Confirm Password không được để trống!");
                    isValid[0] = false;

                }else if (!charSequence.toString().equals(password.getText().toString())){
                    errorConfirm.setError("2 Password phải giống nhau!");
                    isValid[0] = false;

                }else {
                    errorConfirm.setError(null);
                    isValid[0] = true;

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        signup.setOnClickListener(view -> {
            boolean isEmailValid = isValidEmail(email.getText().toString());
            boolean isUsernameValid = isValidUsername(username.getText().toString());
            boolean isPasswordValid = isValidPassword(password.getText().toString());
            boolean isConfirmPasswordValid = isValidConfirm(confirmPassword.getText().toString(), password.getText().toString());

            if (isEmailValid && isUsernameValid && isPasswordValid && isConfirmPasswordValid) {
                bundle.putString("emailSignup", email.getText().toString());
                bundle.putString("nameSignup", username.getText().toString());
                bundle.putString("passSignup", password.getText().toString());
                Intent intent = new Intent(this, LoginActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(),"Lỗi!",Toast.LENGTH_SHORT).show();

            }
        });

    }
    public boolean isValidUsername(String username){
        if(username == null){
                return  false;
        }else
            return true;
    }
    public boolean isValidPassword(String password){
            if(password == null){
                    return  false;
            }
            else
                return true;
        }
    public boolean isValidConfirm(String confPassword, String password){
            if(confPassword == null){
                    return  false;
            } if (confPassword == password) {
                return false;
            }else
                 return true;
        }

    public boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}