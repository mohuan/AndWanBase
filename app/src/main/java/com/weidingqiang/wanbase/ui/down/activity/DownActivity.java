package com.weidingqiang.wanbase.ui.down.activity;

import android.content.Context;
import android.content.Intent;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootActivity;
import com.weidingqiang.wanbase.ui.down.contract.DownContract;
import com.weidingqiang.wanbase.ui.down.presenter.DownPresenter;

/**
 * Created by Lionel2Messi
 */
public class DownActivity extends RootActivity<DownPresenter> implements DownContract.View {

    /**
     * 打开新Activity
     *
     * @param context
     * @return
     */
    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, DownActivity.class);
        return intent;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_down;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void responeError(String errorMsg) {

    }
}