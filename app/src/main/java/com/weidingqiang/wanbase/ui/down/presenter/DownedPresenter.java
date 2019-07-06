package com.weidingqiang.wanbase.ui.down.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.ui.down.contract.DownedContract;

import javax.inject.Inject;

/**
 * Created by Lionel2Messi
 */
public class DownedPresenter extends RxPresenter<DownedContract.View> implements DownedContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public DownedPresenter(DataManager mDataManager) {
        super(mDataManager);
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(DownedContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

    }
}