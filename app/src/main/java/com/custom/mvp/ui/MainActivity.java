package com.custom.mvp.ui;

import android.os.Bundle;
import android.view.View;

import com.custom.core.base.mvp.BaseActivity;
import com.custom.core.unit.MyLog;
import com.custom.mvp.R;
import com.custom.mvp.di.component.DaggerUserComponent;
import com.custom.mvp.model.User;
import com.custom.mvp.ui.contract.MainContract;
import com.custom.mvp.ui.model.MainModel;
import com.custom.mvp.ui.presenter.MainPresenter;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    private final String TAG = this.getClass().getSimpleName();

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerUserComponent.builder().build().inject(this);
    }

    @Override
    protected int initLayout(@Nullable Bundle savedInstanceState) {
        return 0;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainPresenter(new MainModel(),this);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }

    public void injectUser(View view) {
        user.setAge("30");
        user.setName("杨胜文");
        MyLog.d(TAG, "MainActivity.onCreate：" + user.toString());
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void hidLoadingDialog() {

    }
}
