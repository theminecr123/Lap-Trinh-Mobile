package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String s;
    String inFo;
    String gioiTinh;

    String soThich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText hoTen = findViewById(R.id.edtHoTen);
        EditText tuoi = findViewById(R.id.edtTuoi);
        EditText mssv = findViewById(R.id.edtMSSV);
        RadioButton Nam = findViewById(R.id.rdbNam);
        CheckBox game = findViewById(R.id.checkGame);
        CheckBox film = findViewById(R.id.checkFilm);


        TextView info = findViewById(R.id.txtInfo);
        Button btnSave = findViewById(R.id.btnLuu);
        btnSave.setOnClickListener(v->{
            if(Nam.isChecked()){
                gioiTinh = "Nam";
            }else {
                gioiTinh = "Nữ";
            }

            if (game.isChecked()){
                soThich += "Sở thích: Game, " ;
            }else if(film.isChecked()){
                soThich += "Film";
            }else
                soThich +="Không có sở thích";

            s = "Tên:"+hoTen.getText().toString() +
                    "\n" +"Tuổi: "+ tuoi.getText().toString() +
                    "\n" + "MSSV: "+ mssv.getText().toString();
            inFo = s + "\nGiới tính: "+gioiTinh + "\n" + soThich;

            info.setText(inFo);
                });


    }
}