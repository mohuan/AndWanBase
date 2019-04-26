package com.weidingqiang.wanbase.ui.help.activity;

import android.content.Context;
import android.content.Intent;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootActivity;
import com.weidingqiang.wanbase.ui.help.contract.HelpContract;
import com.weidingqiang.wanbase.ui.help.presenter.HelpPresenter;

/**
 * Created by skyworth
 */
public class HelpActivity extends RootActivity<HelpPresenter> implements HelpContract.View {

    /**
     * 打开新Activity
     *
     * @param context
     * @return
     */
    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, HelpActivity.class);
        return intent;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_help;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void responeError(String errorMsg) {

    }
}