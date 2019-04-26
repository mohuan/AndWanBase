package com.weidingqiang.wanbase.base;


import com.weidingqiang.rxqwelibrary.base.BasePresenter;
import com.weidingqiang.rxqwelibrary.base.BaseView;
import com.weidingqiang.rxqwelibrary.base.SimpleFragmentActivity;
import com.weidingqiang.wanbase.app.AppContext;
import com.weidingqiang.wanbase.di.component.ActivityComponent;
import com.weidingqiang.wanbase.di.component.DaggerActivityComponent;
import com.weidingqiang.wanbase.di.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by codeest on 2016/8/2.
 * MVP activity基类
 */
public abstract class BaseFragmentActivity<T extends BasePresenter> extends SimpleFragmentActivity implements BaseView {

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(AppContext.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
//        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    protected abstract void initInject();
}