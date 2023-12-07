package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentStateAdapter {
    private List<MonHoc> monHocList;
    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public PageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public PageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        monHocList = MonHoc.getAllMonHoc();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        MonHoc monHoc  = monHocList.get(position);
        return FragmentMonHoc.newInstance(monHoc);
    }

    @Override
    public int getItemCount() {
        return monHocList.size();
    }
}
