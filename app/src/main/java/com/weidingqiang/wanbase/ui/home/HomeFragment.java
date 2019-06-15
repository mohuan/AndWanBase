package com.weidingqiang.wanbase.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.owen.focus.FocusBorder;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.model.bean.FeedArticleListData;
import com.weidingqiang.wanbase.ui.help.activity.HelpActivity;
import com.weidingqiang.wanbase.ui.main.adapter.NewsAdapter;
import com.weidingqiang.wanbase.ui.main.contract.NewsContract;
import com.weidingqiang.wanbase.ui.main.presenter.NewsPresenter;
import com.weidingqiang.wanbase.widget.actionbar.XBaseTopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Lionel2Messi
 */
public class HomeFragment extends RootFragment<NewsPresenter> implements NewsContract.View {

    @BindView(R.id.image_1)
    ImageView image_1;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initEventAndData() {

        mFocusBorder.boundGlobalFocusListener(new FocusBorder.OnFocusCallback() {
            @Override
            public FocusBorder.Options onFocus(View oldFocus, View newFocus) {
                if (null != newFocus) {
                    switch (newFocus.getId()) {
                        case R.id.round_frame_layout_2:
                            return createColorBorderOptions(10);
                        case R.id.image_1:
                        case R.id.image_2:
                            return createColorBorderOptions(4);
                        default:
                            break;
                    }
                }
                mFocusBorder.setVisible(false);
                //返回null表示不使用焦点框框架
                return null;
            }
        });

    }

    @OnClick(R.id.image_1)
    void click_img(){
        ToastUtils.showShort("点击");
    }

    private FocusBorder.Options createColorBorderOptions(int radius) {
        float scale = 1.2f;
        return FocusBorder.OptionsFactory.get(scale, scale, dp2px(radius) * scale);
    }

    private float dp2px(int dp) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }


    @Override
    public void responeError(String errorMsg) {

    }

    @Override
    public void getFeedArticleListSuccess(FeedArticleListData feedArticleListData) {

    }



}