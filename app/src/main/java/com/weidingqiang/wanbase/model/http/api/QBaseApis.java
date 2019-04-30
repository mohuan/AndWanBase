package com.weidingqiang.wanbase.model.http.api;

import com.weidingqiang.wanbase.model.bean.FeedArticleListData;
import com.weidingqiang.wanbase.model.bean.UserVO;
import com.weidingqiang.wanbase.model.http.response.HttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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



    //首页数据
    @GET("/article/list/{num}/json")
    Flowable<HttpResponse<FeedArticleListData>> getFeedArticleList(@Path("num") int num);


}


