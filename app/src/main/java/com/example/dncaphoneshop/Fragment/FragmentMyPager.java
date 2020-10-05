package com.example.dncaphoneshop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.dncaphoneshop.R;

public class FragmentMyPager extends FragmentStatePagerAdapter {

    public static String KEY = "duLieu";
    ImageView ivView;

    public FragmentMyPager(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view_page, container, false);

        ivView = (ImageView)view.findViewById(R.id.ivView);

        return view;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

            case 1:

            case 2:

            case 3:

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
