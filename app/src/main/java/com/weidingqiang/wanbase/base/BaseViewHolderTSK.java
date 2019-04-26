package com.weidingqiang.wanbase.base;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * 作者：weidingqiang on 2018/4/11 17:02
 * 邮箱：weidingqiang@163.com
 */

public class BaseViewHolderTSK extends BaseViewHolder {

    public BaseViewHolderTSK(final View view){
        super(view);
        AutoUtils.autoSize(itemView);
    }
}
