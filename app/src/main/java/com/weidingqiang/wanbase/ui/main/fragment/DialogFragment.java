package com.weidingqiang.wanbase.ui.main.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ObjectUtils;
import com.jakewharton.rxbinding2.view.RxView;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.ViewHolder;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.ui.main.contract.DialogContract;
import com.weidingqiang.wanbase.ui.main.presenter.DialogPresenter;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * Created by Lionel2Messi
 */
public class DialogFragment extends RootFragment<DialogPresenter> implements DialogContract.View {


    @BindView(R.id.dialog_button)
    Button dialog_button;

    private DialogPlus logoutDialog;

    public static DialogFragment newInstance() {
        Bundle args = new Bundle();

        DialogFragment fragment = new DialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dialog;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.addRxBindingSubscribe(RxView.clicks(dialog_button)
                .throttleFirst(2, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o ->
                        showDialog()
                ));
    }

    private void showDialog(){
        if (ObjectUtils.isEmpty(logoutDialog)) {
            logoutDialog = DialogPlus.newDialog(getContext())
                    .setGravity(Gravity.CENTER)
                    .setContentHolder(new ViewHolder(R.layout.dialog_logout))
                    .setContentBackgroundResource(R.drawable.dialog_write_corner_bg)
                    .setCancelable(true)//设置不可取消   可以取消
                    .setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(DialogPlus dialog, View view) {
                            switch (view.getId()) {
                                case R.id.dialog_logout_btn_cancel:
                                    dialog.dismiss();
                                    break;
                                case R.id.dialog_logout_btn_confirm:

                                    dialog.dismiss();
                                    break;
                            }
                        }
                    }).create();
        }
        logoutDialog.show();
    }

    @Override
    public void responeError(String errorMsg) {

    }

}