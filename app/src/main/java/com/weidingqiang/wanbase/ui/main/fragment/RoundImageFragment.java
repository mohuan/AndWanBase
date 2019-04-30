package com.weidingqiang.wanbase.ui.main.fragment;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.ui.main.contract.RoundImageContract;
import com.weidingqiang.wanbase.ui.main.presenter.RoundImagePresenter;
import com.weidingqiang.wanbase.widget.glide.GlideRoundTransform;

import butterknife.BindView;

/**
 * Created by Lionel2Messi
 */
public class RoundImageFragment extends RootFragment<RoundImagePresenter> implements RoundImageContract.View {

    @BindView(R.id.round_image)
    ImageView round_image;

    public static RoundImageFragment newInstance() {
        Bundle args = new Bundle();

        RoundImageFragment fragment = new RoundImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_round_image;
    }

    @Override
    protected void initEventAndData() {
        Glide.with(mContext)
                .load("https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png")
                .centerCrop()
                .transform(new CenterCrop(mContext), new GlideRoundTransform(mContext, 10))
                .into(round_image);
    }

    @Override
    public void responeError(String errorMsg) {

    }

}