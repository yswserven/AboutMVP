package com.custom.core.base.mvp;

import android.os.Bundle;
import android.view.InflateException;

import com.custom.core.base.mvp.iface.IActivity;
import com.custom.core.base.mvp.iface.IPresenter;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by: Ysw on 2020/2/23.
 */
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IActivity {
    private Unbinder unbinder;

    @Inject
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
        initData(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null && unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
        }
        this.unbinder = null;
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        mPresenter = null;
    }
}
