package com.weidingqiang.wanbase.ui.down.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.ui.down.contract.DownContract;

import javax.inject.Inject;

/**
 * Created by Lionel2Messi
 */
public class DownPresenter extends RxPresenter<DownContract.View> implements DownContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public DownPresenter(DataManager mDataManager) {
        super(mDataManager);
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(DownContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

    }
}