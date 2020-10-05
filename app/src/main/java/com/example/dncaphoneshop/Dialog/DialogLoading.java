package com.example.dncaphoneshop.Dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.dncaphoneshop.R;

public class DialogLoading {

    Context context;
    String body;
    AlertDialog alertDialog;

    public DialogLoading(Context context, String body) {
        this.context = context;
        this.body = body;
    }

    public DialogLoading(Context context, AlertDialog alertDialog, String body) {
        this.context = context;
        this.alertDialog = alertDialog;
        this.body = body;
    }

    public void showDialog() {
        @SuppressLint("ServiceCast") LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.ACTIVITY_SERVICE); // = context.getLayoutInflater()
        View view = inflater.inflate(R.layout.dialog_loading, null);
        TextView txtBody = view.findViewById(R.id.txtBody);
        txtBody.setText(body);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    public void hideDialog(){
        alertDialog.dismiss();
    }
}
