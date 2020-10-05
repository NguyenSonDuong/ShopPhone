package com.example.dncaphoneshop;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.dncaphoneshop.retrofit.API;
import com.example.dncaphoneshop.retrofit.FragmentLogin;

import io.reactivex.disposables.CompositeDisposable;

public class FragmentChangePassWord extends Fragment implements View.OnClickListener
{
    private EditText edtPassword, edtNewPassword, edtConfirmNewPassword;
    Button btnChangePassword;

    private AwesomeValidation awesomeValidation;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private API api;
    private boolean checkFormChange = false;

    public static FragmentChangePassWord newInstance(String param1, String param2) {
        FragmentChangePassWord fragment = new FragmentChangePassWord();
        Bundle args = new Bundle();
        return fragment;
    }
    public void mapping(View view) {
        edtPassword = view.findViewById(R.id.edtPassword);
        edtNewPassword = view.findViewById(R.id.edtNewPassword);
        edtConfirmNewPassword = view.findViewById(R.id.edtConfirmNewPassword);
        btnChangePassword = view.findViewById(R.id.btnChangePassword);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_change_password,container,false);
        mapping(view);
        textChange();
        validator();
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNewPassword.getText().toString() != edtConfirmNewPassword.getText().toString()){
                    Toast.makeText(getContext(), "2 mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Thay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();

                }
                MainActivity.replaceFragment(new FragmentLogin(),false,getFragmentManager());
            }
        });
        return view;
    }

    public void textChange() {
        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")) {

                    checkFormChange = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtNewPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")) {

                    checkFormChange = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtConfirmNewPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")) {

                    checkFormChange = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void validator() {
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(getActivity(), R.id.edtNewPassword, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if(s.length() >= 6) return true;
                return false;
            }
        }), R.string.password_length_validator);
        awesomeValidation.addValidation(getActivity(), R.id.edtConfirmNewPassword, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if(s.length() >= 6) return true;
                return false;
            }
        }), R.string.password_length_validator);
    }
    @Override
    public void onClick(View view) {

    }
}
