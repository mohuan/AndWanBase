package com.weidingqiang.wanbase.model.http;

import com.weidingqiang.wanbase.model.http.api.QBaseApis;

import javax.inject.Inject;

/**
 */
public class RetrofitHelper implements HttpHelper {

    private QBaseApis qBaseApis;

    @Inject
    public RetrofitHelper(QBaseApis qBaseApis) {
        this.qBaseApis = qBaseApis;
    }


}
