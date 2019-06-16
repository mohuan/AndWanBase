package com.weidingqiang.wanbase.ui.home;

import android.os.Bundle;

import com.owen.tab.TvTabLayout;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.model.bean.FeedArticleListData;
import com.weidingqiang.wanbase.ui.main.contract.NewsContract;
import com.weidingqiang.wanbase.ui.main.presenter.NewsPresenter;

import butterknife.BindView;

/**
 * Created by Lionel2Messi
 */
public class HomeFragment3 extends RootFragment<NewsPresenter> implements NewsContract.View {

    private String[] mVals = new String[]
            {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView"};


    @BindView(R.id.tablayout)
    TvTabLayout tablayout;

    @BindView(R.id.tablayout1)
    TvTabLayout tablayout1;

    @BindView(R.id.tablayout2)
    TvTabLayout tablayout2;

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
        for(int i=0; i<mVals.length; i++) {
            tablayout.addTab(tablayout.newTab().setText(mVals[i]));
            tablayout1.addTab(tablayout1.newTab().setText(mVals[i]));
            tablayout2.addTab(tablayout2.newTab().setText(mVals[i]));
//            mTabLayout3.addTab(mTabLayout3.newTab().setText("标题"+i));
        }

        tablayout.selectTab(0);
    }


    @Override
    public void responeError(String errorMsg) {

    }

    @Override
    public void getFeedArticleListSuccess(FeedArticleListData feedArticleListData) {

    }
}