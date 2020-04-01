package com.custom.core.base.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.custom.core.R;


public class LoadingDialog {

    private Dialog dialog;

    public LoadingDialog(Context context) {
        dialog = new Dialog(context, R.style.DialogTransparentNoTitle);
        dialog.setContentView(createView(context));
        dialog.setCanceledOnTouchOutside(false);
    }

    public void show() {
        if(!dialog.isShowing()) {
            dialog.show();
        }
    }

    public void cancel() {
        if(dialog.isShowing()) {
            dialog.cancel();
        }
    }

    public void dismiss() {
        if(dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        return view;
    }

}
