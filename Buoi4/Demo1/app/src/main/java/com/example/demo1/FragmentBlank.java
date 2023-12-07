package com.example.demo1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentBlank extends Fragment {
    TextView textView;
    public FragmentBlank(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank,container,false);
        textView = view.findViewById(R.id.txtIMG);
        return view;
    }

    public void setImage(String text){
        textView.setText(text);
    }

}
