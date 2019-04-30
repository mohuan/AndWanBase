package com.weidingqiang.wanbase.model.http;

import com.weidingqiang.wanbase.model.bean.FeedArticleListData;
import com.weidingqiang.wanbase.model.bean.UserVO;
import com.weidingqiang.wanbase.model.http.api.QBaseApis;
import com.weidingqiang.wanbase.model.http.response.HttpResponse;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 */
public class RetrofitHelper implements HttpHelper {

    private QBaseApis qBaseApis;

    @Inject
    public RetrofitHelper(QBaseApis qBaseApis) {
        this.qBaseApis = qBaseApis;
    }

    @Override
    public Flowable<HttpResponse<UserVO>> postLogin(String username, String password) {
        return qBaseApis.postLogin(username, password);
    }

    @Override
    public Flowable<HttpResponse<FeedArticleListData>> getFeedArticleList(int num) {
        return qBaseApis.getFeedArticleList(num);
    }
}
