package com.weidingqiang.wanbase.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.model.bean.FeedArticleListData;
import com.weidingqiang.wanbase.ui.main.contract.NewsContract;
import com.weidingqiang.wanbase.ui.main.presenter.NewsPresenter;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import com.zhy.view.flowlayout.TagView;

import java.util.Set;

import butterknife.BindView;

/**
 * Created by Lionel2Messi
 */
public class HomeFragment2 extends RootFragment<NewsPresenter> implements NewsContract.View {

    private String[] mVals = new String[]
            {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView"};

    @BindView(R.id.id_flowlayout)
    TagFlowLayout mFlowLayout;

    @BindView(R.id.id_flowlayout1)
    TagFlowLayout mFlowLayout1;

    @BindView(R.id.id_flowlayout2)
    TagFlowLayout mFlowLayout2;

    public static HomeFragment2 newInstance() {
        Bundle args = new Bundle();

        HomeFragment2 fragment = new HomeFragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_2;
    }

    @Override
    protected void initEventAndData() {
        mFlowLayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.tv,
                        mFlowLayout, false);
//                tv.setFocusable(true);
                tv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                        for (int i=0;i<mFlowLayout.getChildCount();i++){
                            ((TagView)mFlowLayout.getChildAt(i)).setChecked(false);
                        }
                        onMoveFocusBorder(view, 1.1f);
                        ((TagView)view.getParent()).setChecked(true);
                    }
                });
                tv.setText(s);
                return tv;
            }
        });

        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                for (int i=0;i<mFlowLayout.getChildCount();i++){
                    ((TagView)mFlowLayout.getChildAt(i)).setChecked(false);
                }
                onMoveFocusBorder(view, 1.1f);
                ((TagView)view).setChecked(true);

                return false;
            }
        });



        mFlowLayout1.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.tv,
                        mFlowLayout1, false);
//                tv.setFocusable(true);
                tv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                        for (int i=0;i<mFlowLayout1.getChildCount();i++){
                            ((TagView)mFlowLayout1.getChildAt(i)).setChecked(false);
                        }
                        onMoveFocusBorder(view, 1.1f);
                        ((TagView)view.getParent()).setChecked(true);
                    }
                });
                tv.setText(s);
                return tv;
            }
        });

        mFlowLayout1.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                for (int i=0;i<mFlowLayout1.getChildCount();i++){
                    ((TagView)mFlowLayout1.getChildAt(i)).setChecked(false);
                }
                onMoveFocusBorder(view, 1.1f);
                ((TagView)view).setChecked(true);
                return false;
            }
        });


        mFlowLayout2.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {

                TextView tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.tv,
                        mFlowLayout2, false);
//                tv.setFocusable(true);
                tv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                        for (int i=0;i<mFlowLayout2.getChildCount();i++){
                            ((TagView)mFlowLayout2.getChildAt(i)).setChecked(false);
                        }
                        onMoveFocusBorder(view, 1.1f);
                        ((TagView)view.getParent()).setChecked(true);
                    }
                });
                tv.setText(s);
                return tv;
            }
        });

        mFlowLayout2.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                for (int i=0;i<mFlowLayout2.getChildCount();i++){
                    ((TagView)mFlowLayout2.getChildAt(i)).setChecked(false);
                }
                onMoveFocusBorder(view, 1.1f);
                ((TagView)view).setChecked(true);
                return false;
            }
        });

    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        mFocusBorder.setVisible(false);
    }

    @Override
    public void responeError(String errorMsg) {

    }

    @Override
    public void getFeedArticleListSuccess(FeedArticleListData feedArticleListData) {

    }
}