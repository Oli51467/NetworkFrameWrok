package com.sdu.network;

import android.app.Application;

/**
 * App运行信息接口
 */
public interface INetworkRequiredInfo {

    String getAppVersionName();

    String getAppVersionCode();

    boolean isDebug();

    Application getApplicationContext();
}
