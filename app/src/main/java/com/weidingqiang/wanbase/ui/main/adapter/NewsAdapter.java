package com.weidingqiang.wanbase.ui.main.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.BaseViewHolderTSK;
import com.weidingqiang.wanbase.model.bean.FeedArticleData;

import java.util.List;

/**
 * Created by weidingqiang on 2018/12/20.
 */

public class NewsAdapter extends BaseQuickAdapter<FeedArticleData, BaseViewHolderTSK> {

    public NewsAdapter(int layoutResId, List<FeedArticleData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolderTSK helper, FeedArticleData item) {

        helper.setText(R.id.news_title_tv,item.getTitle());

        helper.setText(R.id.news_contain_tv,item.getChapterName());

//        Glide.with(mContext)
//                .load(ApiConstants.STATIC_FILE+item.getCoverPic())
//                .centerCrop()
//                .into((ImageView)helper.getView(R.id.news_img));
    }
}
