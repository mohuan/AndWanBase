package com.weidingqiang.wanbase.ui.down.fragment;

import android.os.Bundle;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.ui.down.contract.DowningContract;
import com.weidingqiang.wanbase.ui.down.presenter.DowningPresenter;

/**
 * Created by Lionel2Messi
 */
public class DowningFragment extends RootFragment<DowningPresenter> implements DowningContract.View {


    public static DowningFragment newInstance() {
        Bundle args = new Bundle();

        DowningFragment fragment = new DowningFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_downing;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void responeError(String errorMsg) {

    }

}