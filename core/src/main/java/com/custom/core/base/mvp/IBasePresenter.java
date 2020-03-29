package com.custom.core.base.mvp;

/**
 * Created by: Ysw on 2020/2/23.
 */
public interface IBasePresenter<T extends IBaseView> {
    void attachView(T view);

    void detachView();
}
