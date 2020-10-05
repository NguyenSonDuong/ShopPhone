package com.example.dncaphoneshop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dncaphoneshop.Fragment.FragmentSanPham;
import com.example.dncaphoneshop.MainActivity;
import com.example.dncaphoneshop.Model.SanPham;
import com.example.dncaphoneshop.R;

import java.util.ArrayList;

public class AdapterSanPham extends RecyclerView.Adapter<AdapterSanPham.ViewHolder> {

    Context context;
    ArrayList<SanPham> arrayList;

    public AdapterSanPham(Context context, ArrayList<SanPham> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_sp, parent,  false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterSanPham.ViewHolder holder, int position) {

        SanPham sanPham = arrayList.get(position);
        holder.ivSanPham.setImageResource(sanPham.getHinhAnh());
        holder.tvTenSP.setText(sanPham.getTenSP());
        holder.tvGia.setText(sanPham.getGia());
        holder.tvKhuyenMai.setText(sanPham.getKhuyenMai());

        xuLy(holder);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSanPham;
        TextView tvTenSP, tvGia, tvKhuyenMai;
        public ViewHolder(View view) {
            super(view);

            ivSanPham = (ImageView)view.findViewById(R.id.ivSanPham);
            tvTenSP = (TextView) view.findViewById(R.id.tvTenSanPham);
            tvGia = (TextView)view.findViewById(R.id.tvGia);
            tvKhuyenMai = (TextView)view.findViewById(R.id.tvKhuyenMai);


        }
    }

    private void xuLy(ViewHolder holder){
        holder.ivSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                MainActivity.fragmentTransaction.replace(R.id.flHome, new FragmentSanPham());
                MainActivity.fragmentTransaction.commit();
            }
        });
    }
}
