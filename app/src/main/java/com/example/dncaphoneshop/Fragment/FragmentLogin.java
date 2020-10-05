package com.example.dncaphoneshop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.dncaphoneshop.Common.Common;
import com.example.dncaphoneshop.Dialog.DialogLoading;
import com.example.dncaphoneshop.Retrofit.API;
import com.example.dncaphoneshop.Model.DataResponce;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FragmentLogin extends Fragment {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    API api;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        api = Common.getAPI();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void login(String user, String passWord){

        final DialogLoading loading = new DialogLoading(getActivity(), "Đang đăng nhập");
        loading.showDialog();
        Disposable disposable = api.login(user, passWord).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                                                        .subscribe(new Consumer<DataResponce>() {
                                                            @Override
                                                            public void accept(DataResponce dataResponce) throws Exception {
                                                                loading.hideDialog();
                                                            }
                                                        }, new Consumer<Throwable>() {
                                                            @Override
                                                            public void accept(Throwable throwable) throws Exception {
                                                                loading.hideDialog();
                                                                Toast.makeText(getContext(), "Gặp sự cố, thử lại sau", Toast.LENGTH_LONG).show();
                                                                throwable.printStackTrace();
                                                            }
                                                        });


        compositeDisposable.add(disposable);

    }
}
