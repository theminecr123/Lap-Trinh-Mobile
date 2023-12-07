package com.example.nhom03_tuan4;

import java.util.ArrayList;
import java.util.List;

public class KaraokeData {
    private String maSo;
    private String tieuDe;
    private String noiDung;
    private String tacGia;

    public KaraokeData(String maSo, String tieuDe, String noiDung, String tacGia) {
        this.maSo = maSo;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.tacGia = tacGia;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    static List<KaraokeData> layDSKaraoke(){
        List<KaraokeData> list = new ArrayList<>();
        list.add(new KaraokeData("123456","Bai 1","mot con co","1"));
        list.add(new KaraokeData("234567","Bai 2","mot con chim","2"));
        list.add(new KaraokeData("345678","Bai 3","mot con meo","3"));
        list.add(new KaraokeData("456789","Bai 4","mot con cho","4"));
        return list;
    }

}
