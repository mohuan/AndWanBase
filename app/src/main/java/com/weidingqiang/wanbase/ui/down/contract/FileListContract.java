package com.weidingqiang.wanbase.ui.down.contract;

import com.weidingqiang.rxqwelibrary.base.BasePresenter;
import com.weidingqiang.rxqwelibrary.base.BaseView;
import com.weidingqiang.wanbase.model.bean.FeedArticleListData;

/**
 * Created by weidingqiang
 */
public interface FileListContract {

    interface View extends BaseView {
        //返回登陆结果
        void responeError(String errorMsg);

        void getFeedArticleListSuccess(FeedArticleListData feedArticleListData);
    }

    interface Presenter extends BasePresenter<View> {
        void getFeedArticleList(int num);
    }
}