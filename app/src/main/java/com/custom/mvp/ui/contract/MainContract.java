package com.custom.mvp.ui.contract;

import com.custom.core.base.mvp.iface.IModel;
import com.custom.core.base.mvp.iface.IView;
import com.custom.mvp.model.User;

import java.util.List;

public interface MainContract  {

     interface View extends IView{
        void successHttpData(List<User> list);
    }

     interface Model extends IModel{

        void getHttpData();
    }
}
