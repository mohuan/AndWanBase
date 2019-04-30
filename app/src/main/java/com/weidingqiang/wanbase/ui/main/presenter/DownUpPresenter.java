package com.weidingqiang.wanbase.ui.main.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.ui.main.contract.DownUpContract;

import javax.inject.Inject;

/**
 * Created by Lionel2Messi
 */
public class DownUpPresenter extends RxPresenter<DownUpContract.View> implements DownUpContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public DownUpPresenter(DataManager mDataManager) {
        super(mDataManager);
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(DownUpContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

    }
}