package com.example.dncaphoneshop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dncaphoneshop.Adapter.AdapterSanPham;
import com.example.dncaphoneshop.Model.SanPham;
import com.example.dncaphoneshop.R;

import java.util.ArrayList;

public class FragmentXemSPAll extends Fragment {

    RecyclerView rvXemSP;
    ArrayList<SanPham> arrayList = new ArrayList<>();
    AdapterSanPham adapterSanPham;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_xem_all, container, false);

        init(view);
        xuLy();
        return view;
    }

    private void init(View view){
        rvXemSP = (RecyclerView)view.findViewById(R.id.rvSPAll);
    }

    private void xuLy(){

        arrayList.add(new SanPham(R.drawable.ic_settings, "IOS XS MAX", "13.000.000", "Giarm 50%"));
        arrayList.add(new SanPham(R.drawable.ic_power_settings, "IOS XS MAX", "13.000.000", "Giarm 50%"));
        arrayList.add(new SanPham(R.drawable.ic_people, "IOS XS MAX", "13.000.000", "Giarm 50%"));
        arrayList.add(new SanPham(R.drawable.ic_notifications, "IOS XS MAX", "13.000.000", "Giarm 50%"));
        arrayList.add(new SanPham(R.drawable.ic_notifications_none, "IOS XS MAX", "13.000.000", "Giarm 50%"));
        arrayList.add(new SanPham(R.drawable.ic_home, "IOS XS MAX", "13.000.000", "Giarm 50%"));
        arrayList.add(new SanPham(R.drawable.ic_baseline_share_24, "IOS XS MAX", "13.000.000", "Giarm 50%"));
        arrayList.add(new SanPham(R.drawable.ic_confirmation, "IOS XS MAX", "13.000.000", "Giarm 50%"));
        arrayList.add(new SanPham(R.drawable.ic_contacts, "IOS XS MAX", "13.000.000", "Giarm 50%"));
        arrayList.add(new SanPham(R.drawable.ic_menu, "IOS XS MAX", "13.000.000", "Giarm 50%"));
        adapterSanPham = new AdapterSanPham(getActivity(), arrayList);
        rvXemSP.setAdapter(adapterSanPham);
        rvXemSP.setLayoutManager(new GridLayoutManager(getContext(), 3));


    }
}
