//package com.example.dncaphoneshop.base;
//
//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.widget.ImageView;
//import androidx.annotation.LayoutRes;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//import androidx.fragment.app.FragmentManager;
//import androidx.recyclerview.widget.RecyclerView;
//import butterknife.BindView;
//import com.example.dncaphoneshop.Common.FragmentUtil;
//import com.example.dncaphoneshop.R;
//import com.google.android.material.navigation.NavigationView;
//import dagger.android.support.DaggerAppCompatActivity;
//
//public abstract class BaseActivity extends DaggerAppCompatActivity {
//    protected FragmentManager fragmentManager;
//    private static final int CAMERA_PERMISSION = 1;
//    FragmentUtil fragmentUtil;
//    public int viewContainer = android.R.id.content;
//    @BindView(R.id.ivMenu)
//    public ImageView ivMenu;
//    @BindView(R.id.ivCart)
//    public  ImageView ivCart;
//    @BindView(R.id.rvDL)
//    public RecyclerView rvDL;
//    @BindView(R.id.naviHome)
//    public NavigationView naviHome;
//
//
//
//    @LayoutRes
//    protected abstract int layoutRes();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        fragmentManager = getSupportFragmentManager();
//        fragmentUtil = FragmentUtil.getInstance();
//    }
//
//    public void launchActivity() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION);
//        }
//    }
//
//
//    public void replaceFragment(BaseFragment fragment) {
//        fragmentUtil.replaceFragment(fragmentManager, fragment, viewContainer);
//    }
//
//    public void replaceFragmentFirst(BaseFragment fragment) {
//        fragmentUtil.replaceFragmentWithoutAdToBackStack(fragmentManager, fragment, viewContainer);
//    }
//
//}
