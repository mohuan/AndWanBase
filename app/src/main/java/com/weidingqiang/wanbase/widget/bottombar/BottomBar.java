package com.weidingqiang.wanbase.widget.bottombar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.weidingqiang.wanbase.R;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;

/**
 * 作者：weidingqiang on 2018/12/15 10:32
 * 邮箱：weidingqiang@163.com
 * 底部导航
 */

public class BottomBar extends AutoLinearLayout implements View.OnClickListener{

    private BottomBarItem bottom_bar_capital;

    private BottomBarItem bottom_bar_news;

    private BottomBarItem bottom_bar_im;

    private BottomBarItem bottom_bar_mine;

    private int position;

    private OnTabSelectedListener mListener;

    private ArrayList<BottomBarItem> arrayList;

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        mListener = onTabSelectedListener;
    }

    public BottomBar(Context context) {
        this(context, null);
    }

    public BottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.bottom_bar_bg, this, true);

        bottom_bar_capital = (BottomBarItem) this.findViewById(R.id.bottom_bar_capital);
        bottom_bar_news = (BottomBarItem) this.findViewById(R.id.bottom_bar_news);
        bottom_bar_im = (BottomBarItem) this.findViewById(R.id.bottom_bar_im);
        bottom_bar_mine = (BottomBarItem) this.findViewById(R.id.bottom_bar_mine);

        arrayList = new ArrayList<>();
        arrayList.add(bottom_bar_capital);
        arrayList.add(bottom_bar_news);
        arrayList.add(bottom_bar_im);
        arrayList.add(bottom_bar_mine);


        bottom_bar_capital.setOnClickListener(this);
        bottom_bar_news.setOnClickListener(this);
        bottom_bar_im.setOnClickListener(this);
        bottom_bar_mine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mListener == null) return;

        for (int i=0;i<arrayList.size();i++){
            BottomBarItem bottomBarItem = (BottomBarItem)arrayList.get(i);
            if(bottomBarItem == (BottomBarItem)v){
                if(position == i) return;
                mListener.onTabSelected(i,position);
                position = i;
                bottomBarItem.setSelected(true);
            }else {
                bottomBarItem.setSelected(false);
            }
        }
    }

    public void setCurrentItem(int position) {
        this.position = position;
        arrayList.get(position).setSelected(true);
    }

    public interface OnTabSelectedListener {
        void onTabSelected(int position, int prePosition);
    }

    public void setImMesCount(int count){
        bottom_bar_im.setUnMsgNum(count);
    }

}
