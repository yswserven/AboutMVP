package com.custom.mvp.ui.contract;

import com.custom.core.base.mvp.iface.IModel;
import com.custom.core.base.mvp.iface.IView;

import io.reactivex.Observable;

public interface MainContract  {

     interface View extends IView{
        void successHttpData(String data);
    }

     interface Model extends IModel{

         Observable<String> getHttpData();
    }
}
