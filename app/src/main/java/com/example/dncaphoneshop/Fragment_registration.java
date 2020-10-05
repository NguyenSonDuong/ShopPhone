package com.example.dncaphoneshop;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.dncaphoneshop.retrofit.API;
import com.example.dncaphoneshop.retrofit.DialogNotification;
import com.example.dncaphoneshop.retrofit.FragmentLogin;

import java.util.Calendar;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class Fragment_registration extends Fragment implements View.OnClickListener{
    EditText edtname,edtNameRS, edtUserNameRS,edtPasswordRS,edtPasswordConfirm,edtVitri,edtGmail,edtSdt,edtDate;
    DatePicker datePicker;
    RadioGroup rdiosex;
    Button btnRegister;
    LinearLayout lnDate;
    RadioButton rdionam,rdionu;
    private API api;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private AwesomeValidation awesomeValidation;


    public Fragment_registration() {
        // Required empty public constructor
    }
    public static Fragment_registration newInstance(String param1, String param2) {
        Fragment_registration fragment = new Fragment_registration();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dangky, container, false);
        mapping(view);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()){

                }
            }
        });

        return view;
    }

    public void mapping(View view){
        edtNameRS = view.findViewById(R.id.edtName);
        edtUserNameRS = view.findViewById(R.id.edtUserNameRS);
        edtPasswordRS = view.findViewById(R.id.edtPasswordRS);
        edtPasswordConfirm = view.findViewById(R.id.edtPasswordConfirm);
        edtVitri = view.findViewById(R.id.edtVitri);
        edtGmail = view.findViewById(R.id.edtGmail);
        edtSdt = view.findViewById(R.id.edtSdt);
        rdiosex = view.findViewById(R.id.rdiosex);
        btnRegister = view.findViewById(R.id.btnRegister);
        edtDate = view.findViewById(R.id.edtDate);
        lnDate = view.findViewById(R.id.lnDate);
        rdionam = view.findViewById(R.id.rdionam);
        rdionu = view.findViewById(R.id.rdionu);
        edtname = view.findViewById(R.id.edtName);
        lnDate.setOnClickListener(this);
        edtDate.setOnClickListener(this);
    }
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public void register(User user){
//        final DialogLoading dialogLoading =new DialogLoading(getActivity(),"Đang đăng ký...");
//        dialogLoading.showDialog();
//        compositeDisposable.add(api.Singup(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Consumer<Message>() {
//            @Override
//            public void accept(Message message) throws Exception {
//                dialogLoading.hideDialog();
//                if (message.getStatus() == 401) {
//                    new DialogNotification(getActivity(), message.getBody(), "error").showDialog();
//                } else {
//                    Toast.makeText(getContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
//                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("account", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("fullName", edtname.getText().toString());
//                    editor.putString("username", edtNameRS.getText().toString());
//                    editor.putString("password", edtPasswordRS.getText().toString());
//                    editor.putString("birthDay", edtDate.getText().toString());
//                    editor.putString("address", edtVitri.getText().toString());
//                    editor.putString("email", edtGmail.getText().toString());
//                    editor.putString("phoneNumber", edtSdt.getText().toString());
//                    if (rdionam.isChecked()) {
//                        editor.putString("sex", rdionam.getText().toString());
//                    } else {
//                        editor.putString("sex", rdionu.getText().toString());
//                    }
//                    editor.commit();
//                    MainActivity.replaceFragment(new FragmentLogin(), false, getFragmentManager());
//                }
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                dialogLoading.hideDialog();
//                Toast.makeText(getContext(), "Gặp sự cố , thử lại sau", Toast.LENGTH_SHORT).show();
//            }
//        }));
//    }

    public void validator() {
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(getActivity(),R.id.edtName, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                Log.d("TAG", "compare: "+s);
                if (s.length() > 0) return true;
                return false;
            }
        }),R.string.name_null_validator);
        awesomeValidation.addValidation(getActivity(),R.id.edtUserNameRS, "^[A-Za-z0-9]+$", R.string.username_validator);

        awesomeValidation.addValidation(getActivity(), R.id.edtPasswordRS, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if(s.length() >= 6) return true;
                return false;
            }
        }), R.string.password_length_validator);
        awesomeValidation.addValidation(getActivity(), R.id.edtPasswordConfirm, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if(s.length() >= 6) return true;
                return false;
            }
        }), R.string.password_length_validator);
        awesomeValidation.addValidation(getActivity(),R.id.edtDate,String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if(s != ""){
                    return true;
                }
                return false;
            }
        }),R.string.date_null);
        awesomeValidation.addValidation(getActivity(),R.id.edtVitri, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if (s != ""){
                    return true;
                }
                return false;
            }
        }),R.string.vitri_null);
        awesomeValidation.addValidation(getActivity(),R.id.edtGmail, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if (s.length() >= 12){
                    return  true;
                }
                return false;
            }
        }),R.string.email_validator);
        awesomeValidation.addValidation(getActivity(),R.id.edtSdt, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if (s.length() >=9 && s.length() <=12){
                    return true;
                }
                return false;
            }
        }),R.string.sdt_erro);
        awesomeValidation.addValidation(getActivity(),R.id.rdiosex, String.valueOf(new SimpleCustomValidation() {
            @Override
            public boolean compare(String s) {
                if (rdionam.isChecked() || rdionu.isChecked()){
                    return true;
                }
                return false;
            }
        }),R.string.sex_to_you);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        validator();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

    @Override
    public void onClick(View view) {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();


    }
}
