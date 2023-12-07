package com.example.demo1;

import java.util.ArrayList;
import java.util.List;

public class National {
    String name;
    String urlImg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public National(String name, String urlImg) {
        this.name = name;
        this.urlImg = urlImg;
    }

    public static List<National> getList(){
        List<National>listNation = new ArrayList<>();
        listNation.add(new National("Việt Nam",""));
    }
}
