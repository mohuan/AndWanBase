package com.weidingqiang.wanbase.ui.main.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.model.bean.FeedArticleListData;
import com.weidingqiang.wanbase.ui.help.activity.HelpActivity;
import com.weidingqiang.wanbase.ui.main.adapter.NewsAdapter;
import com.weidingqiang.wanbase.ui.main.contract.NewsContract;
import com.weidingqiang.wanbase.ui.main.presenter.NewsPresenter;
import com.weidingqiang.wanbase.widget.actionbar.XBaseTopBar;

import butterknife.BindView;

/**
 * Created by Lionel2Messi
 */
public class NewsFragment extends RootFragment<NewsPresenter> implements NewsContract.View {

    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    @BindView(R.id.base_topbar)
    XBaseTopBar base_topbar;

    private int currentNum = 0;

    private NewsAdapter newsAdapter;

    public static NewsFragment newInstance() {
        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();

        stateLoading();

        mPresenter.getFeedArticleList(currentNum);
    }

    @Override
    public void getFeedArticleListSuccess(FeedArticleListData feedArticleListData) {
        if(newsAdapter == null){
            //添加自定义分割线
            DividerItemDecoration divider = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
            divider.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.mine_specail_list_divider));
            rv_list.addItemDecoration(divider);

            rv_list.setLayoutManager(new LinearLayoutManager(getContext()));


            newsAdapter = new NewsAdapter(R.layout.news_list_item,feedArticleListData.getDatas());

            newsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    getContext().startActivity(HelpActivity.newInstance(getContext(), newsAdapter.getItem(position).getLink()));
                }
            });

            rv_list.setAdapter(newsAdapter);
        }else {
            rv_list.smoothScrollToPosition(0);
//            newsAdapter.setNewData(newsVO.getDataList());
        }

        stateMain();
    }

    @Override
    public void responeError(String errorMsg) {

    }

}