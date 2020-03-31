package com.custom.mvp.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.custom.core.base.mvp.BaseActivity;
import com.custom.mvp.R;
import com.custom.mvp.ui.contract.MainContract;
import com.custom.mvp.ui.model.MainModel;
import com.custom.mvp.ui.presenter.MainPresenter;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    private final String TAG = this.getClass().getSimpleName();
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvName = findViewById(R.id.tv_name);
    }


    @Override
    public int initLayout(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void initPresenter() {
        new MainPresenter(new MainModel(), this);
    }

    @Override
    public void showLoadingDialog() {
        Toast.makeText(this, "开始网络请求", Toast.LENGTH_SHORT).show();
        Log.d("Ysw", "showLoadingDialog: 开始网络请求");
    }

    @Override
    public void hidLoadingDialog() {
        Toast.makeText(this, "结束网络请求", Toast.LENGTH_SHORT).show();
        Log.d("Ysw", "hidLoadingDialog: 结束网络请求");
    }

    public void getNetData(View view) {
        mPresenter.getUserInfo();
    }


    @Override
    public void successHttpData(String data) {
        Log.d("Ysw", "successHttpData: data = " + data.toString());
    }
}
