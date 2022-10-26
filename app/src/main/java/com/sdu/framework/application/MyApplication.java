package com.sdu.framework.application;

import android.app.Application;

import com.sdu.network.NetworkApi;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        NetworkApi.init(new NetworkRequiredInfo(this));
    }
}
