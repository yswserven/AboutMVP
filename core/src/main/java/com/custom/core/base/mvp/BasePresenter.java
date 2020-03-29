package com.custom.core.base.mvp;

import com.custom.core.base.mvp.iface.IModel;
import com.custom.core.base.mvp.iface.IPresenter;
import com.custom.core.base.mvp.iface.IView;

/**
 * Created by: Ysw on 2020/3/29.
 */
public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {
    protected M mModel;
    protected V mRootView;

    public BasePresenter(M mModel, V mRootView) {
        this.mModel = mModel;
        this.mRootView = mRootView;
        onStart();
    }

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter() {
        onStart();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        if (mModel != null)
            mModel.onDestroy();
        this.mModel = null;
        this.mRootView = null;
    }
}
