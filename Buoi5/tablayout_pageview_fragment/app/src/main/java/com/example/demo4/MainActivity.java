package com.example.demo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of ViewPager and TabLayout
        viewPager = (ViewPager2) findViewById(R.id.viewPage);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
// Create a new Tab named "First"
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("First"); // set the Text for the first Tab
        firstTab.setIcon(R.drawable.ic_launcher_foreground); // set an icon for the
// first tab
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout
// Create a new Tab named "Second"
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Second"); // set the Text for the second Tab
        secondTab.setIcon(R.drawable.ic_launcher_foreground); // set an icon for the second tab
        tabLayout.addTab(secondTab); // add  the tab  in the TabLayout
// Create a new Tab named "Third"
        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("Third"); // set the Text for the first Tab
        thirdTab.setIcon(R.drawable.ic_launcher_foreground); // set an icon for the first tab
        tabLayout.addTab(thirdTab); // add  the tab at in the TabLayout

        FragmentAdapter adapter = new FragmentAdapter(this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        // Thiết lập liên kết giữa TabLayout và ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("First");
                    tab.setIcon(R.drawable.ic_launcher_foreground);
                    break;
                case 1:
                    tab.setText("Second");
                    tab.setIcon(R.drawable.ic_launcher_foreground);
                    break;
                case 2:
                    tab.setText("Third");
                    tab.setIcon(R.drawable.ic_launcher_foreground);
                    break;
            }
        }).attach();

    }
}