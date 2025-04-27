package com.example.waterconservationappblank.AddFragmentPackage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0: return new AddDailyFragment();
            case 1: return new AddMonthlyFragment();
            default: return new AddDailyFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
