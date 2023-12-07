package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMonHoc extends Fragment {
    public FragmentMonHoc(MonHoc monHoc){

    }

public static FragmentMonHoc newInstance(MonHoc monHoc) {
        FragmentMonHoc fragment = new FragmentMonHoc(monHoc);
        Bundle args = new Bundle();
        args.putString("TenHinh", monHoc.getImgURL());
        args.putString("MaMH", monHoc.getMaMon());
        args.putString("TenHP", monHoc.getTenMon());
        args.putString("TenGV", monHoc.getMaMon());
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monhoc, container, false);

        if (getArguments() != null) {
            String image= getArguments().getString("TenHinh");
            String maMH = getArguments().getString("MaMH");
            String tenHP = getArguments().getString("TenHP");
            String tenGV = getArguments().getString("TenGV");
            // Cập nhật các TextView, ImageView, etc.
            ImageView imageView = view.findViewById(R.id.imgMonHoc);
            TextView txtHocPhan = view.findViewById(R.id.tvTenMon);
            TextView txtGiaoVien = view.findViewById(R.id.tvTenGV);
            String mon= tenHP + ": "+ maMH;
            txtHocPhan.setText(mon);
            txtGiaoVien.setText(tenGV);
            int imageResId = getResources().getIdentifier(image, "drawable", getActivity().getPackageName());
            if (imageResId != 0) {
                imageView.setImageResource(imageResId);
            }
        }
        return  view;
    }
}
