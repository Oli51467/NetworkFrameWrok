package com.sdu.framework.api;

import com.sdu.framework.bean.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * ApiService接口 统一管理应用所有的接口
 */
public interface ApiService {

    /**
     * 检查用户名和密码是否一致
     */
    @GET("/api/checkUserInfo?userName=djn&password=123")
    Observable<UserResponse> checkUser();
}
