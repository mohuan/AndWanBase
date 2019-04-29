package com.weidingqiang.wanbase.model.http;

import com.weidingqiang.wanbase.model.bean.UserVO;
import com.weidingqiang.wanbase.model.http.response.HttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.Field;

/**
 * 作者：weidingqiang on 2017/7/11 09:56
 * 邮箱：dqwei@iflytek.com
 */

public interface HttpHelper {

    //登陆接口
    Flowable<HttpResponse<UserVO>> postLogin(String username, String password);




}
