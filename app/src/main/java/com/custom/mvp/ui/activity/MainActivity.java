package com.custom.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.custom.core.base.mvp.BaseActivity;
import com.custom.core.unit.MyLog;
import com.custom.mvp.R;
import com.custom.mvp.di.component.DaggerMainComponent;
import com.custom.mvp.di.module.MainModule;
import com.custom.mvp.ui.contract.MainContract;
import com.custom.mvp.ui.presenter.MainPresenter;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }


    @Override
    public int initLayout(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    public void getNetData(View view) {
        mPresenter.getUserInfo();
        startActivity(new Intent(this,UserActivity.class));
    }


    @Override
    public void successHttpData(String data) {
        MyLog.d("Ysw", "successHttpData: data = " + data.toString());
    }
}
