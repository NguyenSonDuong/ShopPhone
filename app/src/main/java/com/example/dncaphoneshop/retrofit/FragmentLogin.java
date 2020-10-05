package com.example.dncaphoneshop.retrofit;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.dncaphoneshop.DialogLoading;
import com.example.dncaphoneshop.FragmentChangePassWord;
import com.example.dncaphoneshop.Fragment_registration;
import com.example.dncaphoneshop.MainActivity;
import com.example.dncaphoneshop.Message;
import com.example.dncaphoneshop.R;
import com.example.dncaphoneshop.SimpleCustomValidation;

import io.reactivex.MaybeEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FragmentLogin extends Fragment implements View.OnClickListener{

    Button btnLogin;
    EditText edtUsername , edtPassword;
    TextView tvForgetPass , tvDangky;
    TextView txtChangePassword;
    ImageView ivHidePassword;
    private MainActivity mainActivity;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private AwesomeValidation awesomeValidation;
    private boolean hidePassword = true;
    private API api;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        btnLogin = view.findViewById(R.id.btnLogin);
        edtUsername = view.findViewById(R.id.edtUsername);
        edtPassword = view.findViewById(R.id.edtPassword);
        tvDangky = view.findViewById(R.id.txtRegister);
        tvForgetPass = view.findViewById(R.id.txtForgetPassword);
        api = RetrofitDL.readData().create(API.class);
        ivHidePassword = view.findViewById(R.id.ivHidePassword);
        txtChangePassword = view.findViewById(R.id.txtForgetPassword);

        getID();
        Singup();
        validator();
        ivHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hidePassword) {
                    ivHidePassword.setImageResource(R.drawable.ic_eye_hide);
                    edtPassword.setTransformationMethod(null);
                }else {
                    ivHidePassword.setImageResource(R.drawable.ic_eye);
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });
        txtChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.replaceFragment(new FragmentChangePassWord(),false,getFragmentManager());
            }
        });
        return view;

    }


        public  void getID(){
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    compositeDisposable.add(api.Login(edtUsername.getText().toString(),edtPassword.getText().toString()).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            validator();
                        }
                    }));

                }
            });

    }
    public void Singup(){
        tvDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.replaceFragment(new Fragment_registration(), true, getFragmentManager());
            }
        });
    }
    public void validator() {
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(getActivity(),R.id.edtUsername, "^[A-Za-z0-9]+$", R.string.username_validator);
        awesomeValidation.addValidation(getActivity(), R.id.edtUsername, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if(s.length() != 0) return true;
                return false;
            }
        }), R.string.name_null_validator);
        awesomeValidation.addValidation(getActivity(), R.id.edtPassword, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if(s.length() >= 6) return true;
                return false;
            }
        }), R.string.password_length_validator);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        validator();
    }

//    public void login(String user , String password){
//        final DialogLoading dialogLoading = new DialogLoading(getActivity(),"Đang đăng nhập");
//        dialogLoading.showDialog();
//        compositeDisposable.add(api.Login(user, password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Consumer<Message>() {
//
//            @Override
//            public void accept(Message message) throws Exception {
//                dialogLoading.hideDialog();
//                if (message.getStatus() == 401){
//                    new DialogNotification(getActivity(),message.getBody(),"error").showDialog();
//                }else
//
//            }
//        }));
//    }
    @Override
    public void onClick(View view) {



        }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}




