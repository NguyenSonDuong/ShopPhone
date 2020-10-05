package com.example.dncaphoneshop.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.example.dncaphoneshop.Adapter.AdapterSanPham;
import com.example.dncaphoneshop.MainActivity;
import com.example.dncaphoneshop.Model.SanPham;
import com.example.dncaphoneshop.R;

import java.util.ArrayList;

public class Fragment_Home extends Fragment {

    ViewPager vpQuangCao;
    TextView tvSPNoiBat, tvDuoi5, tvTren10;
    RecyclerView rvSPNoiBat;
    LinearLayout lnBoLoc;
    RecyclerView rvSanPham;
    Button btXem;
    ArrayList<SanPham> arrayList = new ArrayList<>();
    AdapterSanPham adapterSanPham;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentt_homee, container, false);
        init(view);
        xuLy();
        return view;
    }

    private void init(View view){
        vpQuangCao = (ViewPager) view.findViewById(R.id.vpQuangCao);
        tvSPNoiBat = (TextView)view.findViewById(R.id.tvXemSanPhamNB);
        tvDuoi5 = (TextView)view.findViewById(R.id.tvDuoi5Tr);
        tvTren10 = (TextView)view.findViewById(R.id.tvTren10);
        rvSPNoiBat = (RecyclerView) view.findViewById(R.id.rvSPNoiBat);
        lnBoLoc = (LinearLayout) view.findViewById(R.id.lnBoLoc);
        rvSanPham = (RecyclerView)view.findViewById(R.id.rvSanPham);
        btXem = (Button)view.findViewById(R.id.btXem);


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
        rvSPNoiBat.setAdapter(adapterSanPham);
        rvSPNoiBat.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        lnBoLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boLoc();
            }
        });

        rvSanPham.setAdapter(adapterSanPham);
        rvSanPham.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        tvSPNoiBat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                MainActivity.fragmentTransaction.replace(R.id.flHome, new FragmentXemSPAll());
                MainActivity.fragmentTransaction.commit();
            }
        });

        btXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    private void boLoc(){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_boloc);

        dialog.show();
    }
}
