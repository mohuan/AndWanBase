package com.weidingqiang.wanbase.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.weidingqiang.rxqwelibrary.base.BasePresenter;
import com.weidingqiang.rxqwelibrary.base.BaseView;
import com.weidingqiang.rxqwelibrary.base.SimpleFragment;
import com.weidingqiang.wanbase.app.AppContext;
import com.weidingqiang.wanbase.di.component.DaggerFragmentComponent;
import com.weidingqiang.wanbase.di.component.FragmentComponent;
import com.weidingqiang.wanbase.di.module.FragmentModule;

import javax.inject.Inject;

/**
 * Created by weidingqiang on 2016/8/2.
 * MVP Fragment基类
 */
public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {

    @Inject
    protected T mPresenter;

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(AppContext.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String msg) {
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