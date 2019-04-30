package com.weidingqiang.wanbase.ui.main.fragment;

import android.os.Bundle;
import android.widget.Button;

import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.arialyy.annotations.Download;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadTask;
import com.jakewharton.rxbinding2.view.RxView;
import com.orhanobut.logger.Logger;
import com.weidingqiang.rxqwelibrary.app.AppConstants;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.app.AppContext;
import com.weidingqiang.wanbase.base.RootFragment;
import com.weidingqiang.wanbase.ui.main.contract.DownUpContract;
import com.weidingqiang.wanbase.ui.main.presenter.DownUpPresenter;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * Created by Lionel2Messi
 */
public class DownUpFragment extends RootFragment<DownUpPresenter> implements DownUpContract.View {

    private static final String DOWNLOAD_URL =
            "http://static.gaoshouyou.com/d/4b/d7/e04b308d9cd7f0ad4cac18d1a514544c.apk";

    @BindView(R.id.down_button)
    Button down_button;

    @BindView(R.id.stop_button)
    Button stop_button;

    @BindView(R.id.cancel_button)
    Button cancel_button;

    @BindView(R.id.up_button)
    Button up_button;

    public static DownUpFragment newInstance() {
        Bundle args = new Bundle();

        DownUpFragment fragment = new DownUpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_down_up;
    }

    @Override
    protected void initEventAndData() {
        //https://github.com/AriaLyy/Aria/blob/master/app/src/main/java/com/arialyy/simple/core/download/DownloadDialog.java
        // 也有上传功能
        Aria.download(this).register();

        DownloadEntity entity = Aria.download(this).getDownloadEntity(DOWNLOAD_URL);

        mPresenter.addRxBindingSubscribe(RxView.clicks(down_button)
                .throttleFirst(2, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o ->
                        downLoad()
                ));

        mPresenter.addRxBindingSubscribe(RxView.clicks(stop_button)
                .throttleFirst(2, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o ->
                        Aria.download(this).load(DOWNLOAD_URL).stop()
                ));

        mPresenter.addRxBindingSubscribe(RxView.clicks(cancel_button)
                .throttleFirst(2, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o ->
                        Aria.download(this).load(DOWNLOAD_URL).cancel()
                ));

        mPresenter.addRxBindingSubscribe(RxView.clicks(up_button)
                .throttleFirst(2, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o ->
                        install()
                ));
    }

    private void downLoad(){
        Aria.download(this)
                .load(DOWNLOAD_URL)
                .setFilePath(AppConstants.APK_DOWNLOAD_PATH+ "/飞机大战.apk")
                .start();
    }

    private void install(){
        AllenVersionChecker
                .getInstance()
                .downloadOnly(
                        UIData.create().setDownloadUrl(DOWNLOAD_URL)
                )
                .setForceUpdateListener(() -> {
//                    forceUpdate()
                })
                .executeMission(getContext());
    }

    @Override
    public void responeError(String errorMsg) {

    }

    @Download.onTaskPre public void onTaskPre(DownloadTask task) {
//        mSize.setText(CommonUtil.formatFileSize(task.getFileSize()));
//        setBtState(false);
        Logger.d("onTaskPre",task.getFileSize());
    }

    @Download.onTaskStop public void onTaskStop(DownloadTask task) {
//        setBtState(true);
//        mSpeed.setText(task.getConvertSpeed());
        Logger.d("onTaskStop",task.getConvertSpeed());
    }

    @Download.onTaskCancel public void onTaskCancel(DownloadTask task) {
//        setBtState(true);
//        mPb.setProgress(0);
//        mSpeed.setText(task.getConvertSpeed());
        Logger.d("onTaskCancel",task.getConvertSpeed());
    }

    @Download.onTaskRunning public void onTaskRunning(DownloadTask task) {
//        if (task.getKey().equals(DOWNLOAD_URL)) {
//            mPb.setProgress(task.getPercent());
//            mSpeed.setText(task.getConvertSpeed());
//        }
        Logger.d("onTaskCancel",task.getConvertSpeed());
    }

}