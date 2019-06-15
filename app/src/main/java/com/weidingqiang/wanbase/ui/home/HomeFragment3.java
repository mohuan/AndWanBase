package com.weidingqiang.wanbase.ui.home;

import android.os.Bundle;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.model.bean.FeedArticleListData;
import com.weidingqiang.wanbase.ui.main.contract.NewsContract;
import com.weidingqiang.wanbase.ui.main.presenter.NewsPresenter;

/**
 * Created by Lionel2Messi
 */
public class HomeFragment3 extends RootFragment<NewsPresenter> implements NewsContract.View {


    public static HomeFragment3 newInstance() {
        Bundle args = new Bundle();

        HomeFragment3 fragment = new HomeFragment3();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_3;
    }

    @Override
    protected void initEventAndData() {

    }


    @Override
    public void responeError(String errorMsg) {

    }

    @Override
    public void getFeedArticleListSuccess(FeedArticleListData feedArticleListData) {

    }
}