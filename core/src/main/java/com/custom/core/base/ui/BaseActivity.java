package com.custom.core.base.ui;

import android.os.Bundle;
import android.view.InflateException;

import com.custom.core.base.mvp.IBasePresenter;
import com.custom.core.base.mvp.IBaseView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by: Ysw on 2020/2/23.
 */
public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {
    private Unbinder unbinder;
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            int layoutResID = initLayout(savedInstanceState);
            if (layoutResID != 0) {
                setContentView(layoutResID);
                unbinder = ButterKnife.bind(this);
            }
        } catch (Exception e) {
            if (e instanceof InflateException) throw e;
            e.printStackTrace();
        }
        initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initData(savedInstanceState);
    }

    protected abstract int initLayout(@Nullable Bundle savedInstanceState);

    protected abstract void initPresenter();

    protected abstract void initData(@Nullable Bundle savedInstanceState);


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null && unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
        }
        this.unbinder = null;
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        this.mPresenter = null;
    }
}
