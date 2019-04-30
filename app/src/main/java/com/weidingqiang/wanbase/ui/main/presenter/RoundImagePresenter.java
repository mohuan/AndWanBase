package com.weidingqiang.wanbase.ui.main.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.ui.main.contract.RoundImageContract;

import javax.inject.Inject;

/**
 * Created by Lionel2Messi
 */
public class RoundImagePresenter extends RxPresenter<RoundImageContract.View> implements RoundImageContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public RoundImagePresenter(DataManager mDataManager) {
        super(mDataManager);
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(RoundImageContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

    }
}