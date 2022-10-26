package com.sdu.framework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.sdu.framework.api.ApiService;
import com.sdu.framework.bean.UserResponse;
import com.sdu.network.NetworkApi;
import com.sdu.network.observer.BaseObserver;
import com.sdu.network.utils.KLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestNetwork();
    }

    @SuppressLint("CheckResult")
    private void requestNetwork() {
        NetworkApi.createService(ApiService.class)
                .checkUser()
                .compose(NetworkApi.applySchedulers(new BaseObserver<UserResponse>() {
                    @Override
                    public void onSuccess(UserResponse userResponse) {
                        Toast.makeText(MainActivity.this, userResponse.getStatus() + " " ,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        KLog.e("MainActivity", e.toString());
                        Toast.makeText(MainActivity.this, "访问失败", Toast.LENGTH_SHORT).show();
                    }
                }));
    }
}