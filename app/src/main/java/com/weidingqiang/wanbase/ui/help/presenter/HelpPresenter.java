package com.weidingqiang.wanbase.ui.help.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.ui.help.contract.HelpContract;

import javax.inject.Inject;

/**
 * Created by skyworth
 */
public class HelpPresenter extends RxPresenter<HelpContract.View> implements HelpContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public HelpPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(HelpContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

    }
}