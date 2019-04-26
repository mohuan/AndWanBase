package com.weidingqiang.wanbase.ui.help.fragment;


import android.os.Bundle;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.ui.help.contract.HelpInfoContract;
import com.weidingqiang.wanbase.ui.help.presenter.HelpInfoPresenter;

/**
 * Created by skyworth
 */
public class HelpInfoFragment extends RootFragment<HelpInfoPresenter> implements HelpInfoContract.View {


    public static HelpInfoFragment newInstance() {
        Bundle args = new Bundle();

        HelpInfoFragment fragment = new HelpInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_help_info_fragment;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void responeError(String errorMsg) {

    }

}