package com.custom.core.base.mvp;

/**
 * Created by: Ysw on 2020/3/29.
 */
public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V mView;

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
