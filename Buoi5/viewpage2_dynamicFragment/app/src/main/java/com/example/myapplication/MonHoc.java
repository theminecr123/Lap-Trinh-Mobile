package com.example.myapplication;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MonHoc {

    private String tenMon;
    private String maMon;
    private String imgURL;
    private String tenGV;


    public MonHoc() {
    }
    public MonHoc(String tenMon, String maMon, String imgURL, String tenGV) {
        this.tenMon = tenMon;
        this.maMon = maMon;
        this.imgURL = imgURL;
        this.tenGV = tenGV;
    }


    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

     @NonNull
     public static List<MonHoc> getAllMonHoc(){
        List<MonHoc> monHocList = new ArrayList<>();
        monHocList.add(new MonHoc("Mobile","1","img1","1"));
        monHocList.add(new MonHoc("Web","2","img2","2"));
        monHocList.add(new MonHoc("CSDL","3","img3","3"));
        monHocList.add(new MonHoc("CTDL","4","img4","4"));
        monHocList.add(new MonHoc("OOP","5","img5","5"));

        return monHocList;
    }
}
