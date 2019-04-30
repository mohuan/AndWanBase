package com.weidingqiang.wanbase.ui.main.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.ui.main.contract.DialogContract;

import javax.inject.Inject;

/**
 * Created by Lionel2Messi
 */
public class DialogPresenter extends RxPresenter<DialogContract.View> implements DialogContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public DialogPresenter(DataManager mDataManager) {
        super(mDataManager);
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(DialogContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

    }
}