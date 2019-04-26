package com.weidingqiang.wanbase.ui.help.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.ui.help.contract.HelpInfoContract;

import javax.inject.Inject;

/**
 * Created by skyworth
 */
public class HelpInfoPresenter extends RxPresenter<HelpInfoContract.View> implements HelpInfoContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public HelpInfoPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(HelpInfoContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

    }
}