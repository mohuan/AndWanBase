package com.weidingqiang.wanbase.ui.home;

import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.model.bean.FeedArticleListData;
import com.weidingqiang.wanbase.ui.main.contract.NewsContract;
import com.weidingqiang.wanbase.ui.main.presenter.NewsPresenter;

import butterknife.BindView;
import cn.jzvd.JZMediaSystem;

/**
 * Created by Lionel2Messi
 */
public class HomeFragment4 extends RootFragment<NewsPresenter> implements NewsContract.View {

    @BindView(R.id.jz_video)
    MyJzvdStd jz_video;

    public static HomeFragment4 newInstance() {
        Bundle args = new Bundle();

        HomeFragment4 fragment = new HomeFragment4();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_4;
    }

    @Override
    protected void initEventAndData() {
        jz_video.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , "饺子闭眼睛");
//        jz_video.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(jz_video.thumbImageView);

//        ((IjkMediaPlayer）mMediaPlayer).setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "enable-accurate-seek", 1);

        jz_video.startVideo();

//        JZVideoPlayer
//        jz_video.thumbImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"));
//        jz_video.thumbImageView.;

//        IjkMediaPlayer.seekTo
//        JZMediaSystem.
        //这里只有开始播放时才生效
//        mJzvdStd.seekToInAdvance = 20000;
        //跳转制定位置播放
//        JZMediaManager.seekTo(30000);
//        JZMediaManager
    }


    @Override
    public void responeError(String errorMsg) {

    }

    @Override
    public void getFeedArticleListSuccess(FeedArticleListData feedArticleListData) {

    }
}