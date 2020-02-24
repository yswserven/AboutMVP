package com.custom.core.base.mvp;

/**
 * Created by: Ysw on 2020/2/23.
 */
public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {
    protected M mModel;
    protected V mRootView;

    public BasePresenter(M mModel, V mRootView) {
        this.mModel = mModel;
        this.mRootView = mRootView;
    }

    public BasePresenter(V mRootView) {
        this.mRootView = mRootView;
    }

    public BasePresenter() {
    }

    @Override
    public void onDestroy() {
        if (mModel != null)
            mModel.onDestroy();
        this.mModel = null;
        this.mRootView = null;
    }
}
