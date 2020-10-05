package com.example.dncaphoneshop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.dncaphoneshop.R;
import com.example.dncaphoneshop.Model.SanPhamLoc;

import java.util.ArrayList;

public class AdapterBoLocSP extends BaseAdapter {
    Context context;
    ArrayList<SanPhamLoc> arrayList;



    public AdapterBoLocSP(Context context, ArrayList<SanPhamLoc> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHodle{
        CheckBox cbSP;
        TextView tvSPNB;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHodle hodle;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_danh_muc_sp, null);
            hodle = new ViewHodle();

            convertView.setTag(hodle);
        }else {
            hodle = (ViewHodle) convertView.getTag();
        }

        init(hodle, convertView);
        SanPhamLoc sanPhamLoc = arrayList.get(position);
        hodle.tvSPNB.setText(sanPhamLoc.getName());
        return convertView;
    }

    public void init(ViewHodle hodle, View view){
        hodle.cbSP = (CheckBox)view.findViewById(R.id.cbSP);
        hodle.tvSPNB = (TextView)view.findViewById(R.id.tvSanPham);
    }
}
