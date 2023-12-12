package com.example.demo5_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.demo5_1.Fragments.FragmentAdapter;
import com.example.demo5_1.Fragments.HomeFragment;
import com.example.demo5_1.Fragments.SongFragment;
import com.example.demo5_1.Fragments.SubjectFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize components
        viewPager2 = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottomNavi);

        // Instantiate FragmentAdapter
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        // Set NavigationItemSelectedListener for BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home){
//                replaceFragment(new HomeFragment());
                viewPager2.setCurrentItem(0);
                return true;

            } else if (item.getItemId() == R.id.subject) {
//                replaceFragment(new SubjectFragment());
                viewPager2.setCurrentItem(1);
                return true;


            } else if (item.getItemId() == R.id.song) {
//                replaceFragment(new SongFragment());

                viewPager2.setCurrentItem(2);
                return true;


            }else{
                return false;

            }
        });

        // Update BottomNavigationView when ViewPager2 scrolls
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position)

            {
                bottomNavigationView.setSelectedItemId(bottomNavigationView.getMenu().getItem(position).getItemId());
            }
        });

        // Set initial selection
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

//private void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//    fragmentTransaction.replace(R.id.frame_layout,fragment);
//    fragmentTransaction.commit();
//}

}