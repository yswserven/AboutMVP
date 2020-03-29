package com.custom.mvp.ui.contract;

import com.custom.core.base.mvp.iface.IModel;
import com.custom.core.base.mvp.iface.IView;

public interface MainContract  {

    public interface View extends IView{

    }

    public interface Model extends IModel{

        void getHttpData();
    }
}
