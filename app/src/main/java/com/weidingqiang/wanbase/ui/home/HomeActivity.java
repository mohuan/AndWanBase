package com.weidingqiang.wanbase.ui.home;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.owen.focus.FocusBorder;
import com.owen.tab.TvTabLayout;
import com.owen.widget.TvViewPager;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.base.RootFragmentActivity;
import com.weidingqiang.wanbase.ui.help.contract.HelpContract;
import com.weidingqiang.wanbase.ui.help.presenter.HelpPresenter;

import butterknife.BindView;

/**
 * 2.多行列表
 * 3.视频
 * 4.微信登陆
 * 5.弹框
 */


public class HomeActivity extends RootFragmentActivity<HelpPresenter> implements HelpContract.View, RootFragment.FocusBorderHelper {

    @BindView(R.id.tab_layout)
    TvTabLayout mTabLayout;

    @BindView(R.id.viewPager)
    TvViewPager viewPager;

    @BindView(R.id.tv_test)
    TextView tv_test;

    private FocusBorder mFocusBorder;

    private final String[] tabNames = {
            "热门推荐", "在线试题", "录播课堂",
            "作业查看"
    };

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void responeError(String errorMsg) {

    }

    @Override
    public FocusBorder getFocusBorder() {
        return mFocusBorder;
    }

    @Override
    protected void initEventAndData() {
//        super.initEventAndData();

        mTabLayout.addOnTabSelectedListener(new TabSelectedListener());
        for(String tabName : tabNames) {
            mTabLayout.addTab(mTabLayout.newTab().setText(tabName));
        }
        mTabLayout.selectTab(0);

        // 移动框
        if(null == mFocusBorder) {
            mFocusBorder = new FocusBorder.Builder()
                    .asColor()
                    .borderColorRes(R.color.actionbar_color)
                    .borderWidth(TypedValue.COMPLEX_UNIT_DIP, 3.2f)
                    .shadowColorRes(R.color.green_bright)
                    .shadowWidth(TypedValue.COMPLEX_UNIT_DIP, 22f)
                    .build(this);

            mFocusBorder.boundGlobalFocusListener(new FocusBorder.OnFocusCallback() {
                @Override
                public FocusBorder.Options onFocus(View oldFocus, View newFocus) {
                    if(null != newFocus) {
                        switch (newFocus.getId()) {
                            case R.id.tv_test:
                                float scale = 1.2f;
                                return FocusBorder.OptionsFactory.get(scale, scale, dp2px(20) * scale);

                            default:
                                break;
                        }
                    }
                    //返回null表示不使用焦点框框架
                    return null;
                }
            });

        }

        viewPager.setAdapter(new HomeFragmentAdapter(getSupportFragmentManager(),tabNames));
        mTabLayout.setupWithViewPager(viewPager);
        tv_test.setSelected(true);
    }

    private float dp2px(int dp) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    public class TabSelectedListener implements TvTabLayout.OnTabSelectedListener {
        private Fragment mFragment;

        @Override
        public void onTabSelected(TvTabLayout.Tab tab) {
//            final int position = tab.getPosition();
//            mFragment = getSupportFragmentManager().findFragmentByTag(position + "");
//            FragmentTransaction mFt = getSupportFragmentManager().beginTransaction();
//            if (mFragment == null) {
//                mFragment = Fragment.instantiate(MainActivity.this, fragments[position]);
//                mFt.add(R.id.content, mFragment, String.valueOf(position));
//            } else {
//                mFt.attach(mFragment);
//            }
//            mFt.commit();
        }

        @Override
        public void onTabUnselected(TvTabLayout.Tab tab) {
//            if (mFragment != null) {
//                FragmentTransaction mFt = getSupportFragmentManager().beginTransaction();
//                mFt.detach(mFragment);
//                mFt.commit();
//            }
        }

        @Override
        public void onTabReselected(TvTabLayout.Tab tab) {

        }
    }


    //连续俩下 退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }
}
