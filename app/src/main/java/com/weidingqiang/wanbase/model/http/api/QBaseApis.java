package com.weidingqiang.wanbase.model.http.api;

import com.weidingqiang.wanbase.model.bean.UserVO;
import com.weidingqiang.wanbase.model.http.response.HttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 作者：weidingqiang on 2017/9/7 09:51
 * 邮箱：dqwei@iflytek.com
 * <p>
 * http://www.jianshu.com/p/73216939806a  Retrofit2 使用说明
 */

public interface QBaseApis {

    //登陆-相关
    @FormUrlEncoded
    @POST("/user/login")
    Flowable<HttpResponse<UserVO>> postLogin(@Field("username") String username, @Field("password") String password);
//
//
//
//    //物业列表
//    //typeCode 物业类型：BUILD 一栋/HOUSE 公寓
//    @GET("realty/list.do")
//    Flowable<HttpResponse<PropertyListVO>> getPropertyList(@Header("Authorization") String Authorization, @Query("typeCode") String typeCode);


}


