package com.weidingqiang.wanbase.ui.down.fragment;

import android.os.Bundle;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.ui.down.contract.DownedContract;
import com.weidingqiang.wanbase.ui.down.presenter.DownedPresenter;

/**
 * Created by Lionel2Messi
 */
public class DownedFragment extends RootFragment<DownedPresenter> implements DownedContract.View {


    public static DownedFragment newInstance() {
        Bundle args = new Bundle();

        DownedFragment fragment = new DownedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_downed;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void responeError(String errorMsg) {

    }

}