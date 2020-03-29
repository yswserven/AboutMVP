package com.custom.mvp.ui.presenter;

import com.custom.core.base.mvp.BasePresenter;
import com.custom.mvp.ui.MainActivity;
import com.custom.mvp.ui.contract.MainContract;
import com.custom.mvp.ui.model.MainModel;

public class MainPresenter extends BasePresenter<MainContract.Model,MainContract.View> implements MainContract.Model {

    public MainPresenter(MainContract.Model model,MainContract.View view) {
        super(model,view);
    }

    @Override
    public void getHttpData() {
        //请求网络
        mRootView.showLoadingDialog();
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //请求回调
        mRootView.hidLoadingDialog();
    }
}
