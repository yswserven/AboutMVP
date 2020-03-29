package com.custom.mvp.ui.presenter;

import com.custom.core.base.mvp.BasePresenter;
import com.custom.mvp.model.User;
import com.custom.mvp.ui.contract.MainContract;

import java.util.ArrayList;

public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {

    public MainPresenter(MainContract.Model model, MainContract.View view) {
        super(model, view);
    }

    public void getUserInfo() {
        mRootView.showLoadingDialog();
        try {
            mModel.getHttpData();
            ArrayList<User> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                User user = new User();
                user.setName("名字_" + i);
                user.setAge("年龄_" + (20 + i));
                list.add(user);
            }
            new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(3000);
                        mRootView.successHttpData(list);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //请求回调
        mRootView.hidLoadingDialog();
    }
}
