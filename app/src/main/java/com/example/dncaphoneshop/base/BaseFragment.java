//package com.example.dncaphoneshop.base;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import androidx.annotation.LayoutRes;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import butterknife.ButterKnife;
//import butterknife.Unbinder;
//import dagger.android.support.DaggerFragment;
//import io.reactivex.disposables.CompositeDisposable;
//
//public abstract class BaseFragment extends DaggerFragment{
//
//    BaseActivity baseActivity;
//    Unbinder unbinder;
//    CompositeDisposable disposable;
//    View view;
//
//
//    @LayoutRes
//    protected abstract int layoutRes();
//
//    abstract protected void setUpView();
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        view = setViewContent(inflater, layoutRes(), container);
//        unbinder = ButterKnife.bind(this, view);
//        setUpView();
//
//        return view;
//    }
//
//    private View setViewContent(LayoutInflater inflater, int resLayout, ViewGroup container) {
//        return inflater.inflate(resLayout, null, false);
//
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof BaseActivity)
//            baseActivity = (BaseActivity) context;
//    }
//
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        baseActivity = null;
//    }
//
//    public BaseActivity getParentActivity() {
//        return baseActivity;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        if (unbinder != null) {
//            unbinder.unbind();
//            unbinder = null;
//        }
//    }
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (disposable != null && !disposable.isDisposed()) {
//            disposable.dispose();
//        }
//    }
//
//
//}
