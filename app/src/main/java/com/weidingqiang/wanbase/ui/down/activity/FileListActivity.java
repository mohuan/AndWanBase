package com.weidingqiang.wanbase.ui.down.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.tmall.wireless.tangram.TangramBuilder;
import com.tmall.wireless.tangram.TangramEngine;
import com.tmall.wireless.tangram.support.ExposureSupport;
import com.tmall.wireless.tangram.support.SimpleClickSupport;
import com.tmall.wireless.tangram.support.async.CardLoadSupport;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootActivity;
import com.weidingqiang.wanbase.model.bean.FeedArticleListData;
import com.weidingqiang.wanbase.ui.down.contract.FileListContract;
import com.weidingqiang.wanbase.ui.down.presenter.FileListPresenter;

import butterknife.BindView;

/**
 * Created by weidingqiang
 *
 */
public class FileListActivity extends RootActivity<FileListPresenter> implements FileListContract.View {

    private int currentNum = 0;

    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    private TangramEngine engine;
    /**
     * 打开新Activity
     *
     * @param context
     * @return
     */
    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, FileListActivity.class);
        return intent;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_file_list;
    }

    @Override
    protected void initEventAndData() {
        //初始化 TangramBuilder
        TangramBuilder.InnerBuilder builder = TangramBuilder.newInnerBuilder(getBaseContext());
        //注册自定义的卡片和组件
        //生成TangramEngine实例
        engine = builder.build();

        engine.bindView(rv_list);

        //以下常用三个常用的support，分别处理点击、卡片数据加载、曝光逻辑
//        engine.register(SimpleClickSupport.class, new XXClickSupport());
//        engine.register(CardLoadSupport.class, new XXCardLoadSupport());
//        engine.register(ExposureSupport.class, new XXExposureSuport());

        mPresenter.getFeedArticleList(currentNum);

        initEvent();
    }

    private void initEvent(){
        rv_list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //在 scroll 事件中触发 engine 的 onScroll，内部会触发需要异步加载的卡片去提前加载数据
                engine.onScrolled();
            }
        });
    }

    @Override
    public void responeError(String errorMsg) {

    }

    @Override
    public void getFeedArticleListSuccess(FeedArticleListData feedArticleListData) {

    }

    @Override
    protected void onDestroy() {
        engine.destroy();
        super.onDestroy();
    }
}