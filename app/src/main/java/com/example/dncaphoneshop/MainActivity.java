package com.example.dncaphoneshop;

import android.os.Bundle;
import android.view.MenuItem;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.dncaphoneshop.Fragment.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static FragmentTransaction fragmentTransaction;
    BottomNavigationView btNavi;
    public static FrameLayout flHome;
    ImageView ivMenu, ivCart;
    NavigationView naviHome;
    LinearLayout lnToolar;
    Toolbar tbHome;
    DrawerLayout drawer_Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        trangChu();

        xuLy();
    }

    private void init(){
        btNavi =(BottomNavigationView) findViewById(R.id.btNavi);
        flHome =(FrameLayout) findViewById(R.id.flHome);
        ivCart = (ImageView)findViewById(R.id.ivCart);
        ivMenu = (ImageView) findViewById(R.id.ivMenu);
        naviHome = (NavigationView)findViewById(R.id.naviHome);
        tbHome = (Toolbar)findViewById(R.id.tbHome);
        lnToolar = (LinearLayout)findViewById(R.id.lnToolBar);
        drawer_Home = (DrawerLayout) findViewById(R.id.drawer_Home);
        fragmentManager = getSupportFragmentManager();
        setSupportActionBar(tbHome);
    }

    private void trangChu(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flHome, new Fragment_Home());
        fragmentTransaction.commit();
    }


    public void xuLy() {

        ivCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flHome, new FragmentCart());
                fragmentTransaction.commit();
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });

        btNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.itemTrangChu:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flHome, new Fragment_Home());
                        fragmentTransaction.commit();
                        lnToolar.setVisibility(View.VISIBLE);

                        return true;
                    case R.id.itemTinTuc:

                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flHome, new FragmentTinTuc());
                        fragmentTransaction.commit();
                        lnToolar.setVisibility(View.GONE);
                        return true;

                    case R.id.itemThongBao:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flHome, new FragmenThongBao());
                        fragmentTransaction.commit();
                        lnToolar.setVisibility(View.GONE);
                        return true;

                    case R.id.itemPeople:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flHome, new FragmentPeople());
                        fragmentTransaction.commit();
                        lnToolar.setVisibility(View.GONE);


                        return true;
                }
                return false;
            }
        });

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_Home.openDrawer(GravityCompat.START);
                Toast.makeText(MainActivity.this, "NAVI", Toast.LENGTH_SHORT).show();
            }
        });

        naviHome.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.itemTrangChu:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.flHome, new Fragment_Home());
                        fragmentTransaction.commit();

                        drawer_Home.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.itemHangDienThoai:
                        Toast.makeText(MainActivity.this, "Hãng điện thoại", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.itemLienHe:
                        Toast.makeText(MainActivity.this, "Liên hệ", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.itemThongTin:
                        Toast.makeText(MainActivity.this, "Thông tin", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.itemCaiDat:
                        Toast.makeText(MainActivity.this, "Cài đặt", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.itemShare:
                        Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.itemDangXuat:
                        Toast.makeText(MainActivity.this, "Đăng xuất", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {

        if(fragmentManager.getBackStackEntryCount() > 0){
            fragmentManager.popBackStack();
        }else {
            super.onBackPressed();
        }
    }
}

