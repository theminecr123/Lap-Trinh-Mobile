package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewpageFrag);

        List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add((new FragmentA1()));
        fragmentList.add((new FragmentA2()));
        fragmentList.add((new FragmentA3()));

        Pageview2Adapter adapter = new Pageview2Adapter(getSupportFragmentManager(),getLifecycle(),fragmentList);

        viewPager2.setOrientation(viewPager2.ORIENTATION_VERTICAL);
        viewPager2.setAdapter(adapter);
    }
}