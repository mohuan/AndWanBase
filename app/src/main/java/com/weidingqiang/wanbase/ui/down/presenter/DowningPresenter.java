package com.weidingqiang.wanbase.ui.down.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.ui.down.contract.DowningContract;

import javax.inject.Inject;

/**
 * Created by Lionel2Messi
 */
public class DowningPresenter extends RxPresenter<DowningContract.View> implements DowningContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public DowningPresenter(DataManager mDataManager) {
        super(mDataManager);
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(DowningContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

    }
}