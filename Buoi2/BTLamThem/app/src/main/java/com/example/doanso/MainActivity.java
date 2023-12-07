package com.example.doanso;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnNew;
    private EditText etNumber;
    private TextView tvFeedback;
    private TextView tvLog;
    private  Button btnGuess;
    private TextView tvCount;

    private Button btnFinish;

    private int number =0;
    private int countGuess;
    private boolean isFinished;
    private ArrayList<Integer> log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNew = findViewById(R.id.btnNew);
        etNumber  = findViewById(R.id.edtGuess);
        tvFeedback  = findViewById(R.id.txtKetQua);
        tvLog = findViewById(R.id.txtNhatKy);
        btnGuess = findViewById(R.id.btnGuess);
        tvCount = findViewById(R.id.txt1);

        btnFinish = findViewById(R.id.btnFinish);

        btnFinish.setOnClickListener(v -> {
            onFinish();
        });


        btnNew.setOnClickListener(v -> {

                init();
                onNew();


        });

        btnGuess.setOnClickListener(v -> {
            if(number == 0){
                Toast.makeText(getApplication(),"Vui lòng bắt đầu trò chơi",Toast.LENGTH_SHORT).show();
            }else{
                onGuess();
            }

        });
        etNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (TextUtils.isEmpty(s)) {
                    etNumber.setError("Please enter a number!");
                } else {
                    etNumber.setError(null);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (!isNumeric(s.toString())) {
//                    edtGuess.setError("Please enter a valid integer!");
//                } else {
//                    edtGuess.setError(null);
//                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }


    private void init() {
        number = randomNumber();
        countGuess = 0;
        isFinished = false;
        etNumber.setText("");

        // Khởi tạo lịch sử các lần đoán
        log = new ArrayList<>();
    }

    private void onFinish() {
        tvFeedback.setText("Thất bại! Số cần đoán là " + number);
        tvLog.setText("");
        etNumber.setText("");
        number = 0;


    }
    private int randomNumber() {
        return (int) (Math.random() * 900)+100;
    }

    private String getFeedback(int numberGuess) {
        String feedback = "";
        String numberSecret = String.valueOf(number);
        for (int i = 2; i >= 0; i--) {
            int digitGuess = numberGuess % 10;
            int digitSecret = numberSecret.charAt(i) - '0';
            if (digitGuess == digitSecret) {
                feedback = "+" + feedback;
            } else if (numberSecret.indexOf(String.valueOf(digitGuess)) != -1) {
                feedback = "?" + feedback;
            } else {
                feedback = "-" + feedback;
            }
            numberGuess /= 10;
        }
        return feedback;
    }


    public void onGuess() {
        int numberGuess = Integer.parseInt(etNumber.getText().toString());
        tvCount.setText("Lần đoán: "+ (countGuess+1));
        if (countGuess == 7) {
            isFinished = true;
            tvFeedback.setText("Thất bại! Số cần đoán là " + number);
        } else if (number == numberGuess) {
            isFinished = true;
            tvFeedback.setText("Chúc mừng! Bạn đã đoán đúng số" + number);
        } else {
            tvFeedback.setText(getFeedback(numberGuess));
            countGuess++;

            // Thêm lần đoán mới vào lịch sử
            log.add(numberGuess);

            // Hiển thị lịch sử các lần đoán
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < log.size(); i++) {
                stringBuilder.append(log.get(i));
                if (i < log.size() - 1) {
                    stringBuilder.append("\n");
                }
            }
            tvLog.setText(stringBuilder.toString());
        }
    }

    public void onNew() {
        tvFeedback.setText("");
        tvLog.setText("");
    }




}
