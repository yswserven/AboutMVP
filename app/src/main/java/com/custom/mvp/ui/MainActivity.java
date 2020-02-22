package com.custom.mvp.ui;

import android.os.Bundle;

import com.custom.core.unit.MyLog;
import com.custom.mvp.R;
import com.custom.mvp.di.component.DaggerUserComponent;
import com.custom.mvp.model.User;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerUserComponent.builder().build().inject(this);
        user.setAge("30");
        user.setName("杨胜文");
        MyLog.d(TAG, "MainActivity.onCreate：" + user.toString());
    }
}
