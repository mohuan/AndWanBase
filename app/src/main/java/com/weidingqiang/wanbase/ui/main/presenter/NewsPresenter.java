package com.weidingqiang.wanbase.ui.main.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.ui.main.contract.NewsContract;

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
}