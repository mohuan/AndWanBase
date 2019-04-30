package com.weidingqiang.wanbase.ui.main.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.model.bean.FeedArticleListData;
import com.weidingqiang.wanbase.model.bean.UserVO;
import com.weidingqiang.wanbase.model.http.exception.ApiException;
import com.weidingqiang.wanbase.model.http.response.HttpResponse;
import com.weidingqiang.wanbase.ui.main.contract.NewsContract;
import com.weidingqiang.wanbase.utils.RxUtil;
import com.weidingqiang.wanbase.widget.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by Lionel2Messi
 */
public class NewsPresenter extends RxPresenter<NewsContract.View> implements NewsContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public NewsPresenter(DataManager mDataManager) {
        super(mDataManager);
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(NewsContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

    }

    @Override
    public void getFeedArticleList(int num) {
        addSubscribe(mDataManager.getFeedArticleList(num)
                .compose(RxUtil.<HttpResponse<FeedArticleListData>>rxSchedulerHelper())
                .compose(RxUtil.<FeedArticleListData>handleTestResult())
                .subscribeWith(
                        new CommonSubscriber<FeedArticleListData>(mView) {
                            @Override
                            public void onNext(FeedArticleListData data) {
                                mView.getFeedArticleListSuccess(data);

                            }


                            @Override
                            public void onError(Throwable e) {
                                //当数据返回为null时 做特殊处理
                                try {
                                    int code = ((ApiException) e).getCode();
                                    mView.responeError(e.getMessage());
                                    return;
                                } catch (Exception ex) {

                                }
                                mView.responeError("数据请求失败，请检查网络！");
                            }

                        }
                )
        );
    }
}