package com.weidingqiang.wanbase.ui.main.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.BaseFragmentActivity;
import com.weidingqiang.wanbase.ui.main.contract.MainContract;
import com.weidingqiang.wanbase.ui.main.fragment.DialogFragment;
import com.weidingqiang.wanbase.ui.main.fragment.NewsFragment;
import com.weidingqiang.wanbase.ui.main.fragment.RoundImageFragment;
import com.weidingqiang.wanbase.ui.main.presenter.MainPresenter;
import com.weidingqiang.wanbase.widget.bottombar.BottomBar;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseFragmentActivity<MainPresenter> implements MainContract.View{

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOUR = 3;

    private SupportFragment[] mFragments = new SupportFragment[4];

    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        SupportFragment firstFragment = findFragment(NewsFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = NewsFragment.newInstance();
            mFragments[SECOND] = RoundImageFragment.newInstance();
            mFragments[THIRD] = DialogFragment.newInstance();
            mFragments[FOUR] = NewsFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST], mFragments[SECOND], mFragments[THIRD],mFragments[FOUR]);
        }else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.findFragmentByTag自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(RoundImageFragment.class);
            mFragments[THIRD] = findFragment(DialogFragment.class);
            mFragments[FOUR] = findFragment(NewsFragment.class);
        }

        initView();
        mBottomBar.setCurrentItem(0);
    }

    private void initView(){
        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }
        });
    }

    @Override
    public void responeError(String errorMsg) {

    }

    /**
     * 退出登录后 需要重新进入main时 调用， 在此需要清空数据
     *
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mBottomBar.setCurrentItem(0);
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

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
}
