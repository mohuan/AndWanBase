package com.weidingqiang.wanbase.ui.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragmentActivity;
import com.weidingqiang.wanbase.ui.help.contract.HelpContract;
import com.weidingqiang.wanbase.ui.help.presenter.HelpPresenter;

import butterknife.BindView;
import cn.jzvd.Jzvd;

public class VideoActivity extends RootFragmentActivity<HelpPresenter> implements HelpContract.View {

    private String  TAG="key";

    @BindView(R.id.jz_video)
    MyJzvdStd jz_video;

    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, VideoActivity.class);
        return intent;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_video;
    }

    @Override
    public void responeError(String errorMsg) {

    }

    @Override
    protected void initEventAndData() {

        //设置全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        jz_video.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , "饺子闭眼睛");
//        jz_video.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(jz_video.thumbImageView);

//        ((IjkMediaPlayer）mMediaPlayer).setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "enable-accurate-seek", 1);


        jz_video.gotoScreenFullscreen();
        jz_video.startVideo();

//        jz_video.startFullscreen(this, JzvdStd.class, VideoConstant.videoUrlList[6], "饺子辛苦了");
    }

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.resetAllVideos();
    }


    //    @Override
//    public void onBackPressedSupport() {
//
//        if (Jzvd.backPress()) {
//            return;
//        }
//        super.onBackPressed();
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {

            case KeyEvent.KEYCODE_ENTER:     //确定键enter
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Log.d(TAG,"enter--->");

                jz_video.pause();


                break;

            case KeyEvent.KEYCODE_BACK:    //返回键
                Log.d(TAG,"back--->");
                finish();
                return true;   //这里由于break会退出，所以我们自己要处理掉 不返回上一层

            case KeyEvent.KEYCODE_SETTINGS: //设置键
                Log.d(TAG,"setting--->");

                break;

            case KeyEvent.KEYCODE_DPAD_DOWN:   //向下键

                /*    实际开发中有时候会触发两次，所以要判断一下按下时触发 ，松开按键时不触发
                 *    exp:KeyEvent.ACTION_UP
                 */
                if (event.getAction() == KeyEvent.ACTION_DOWN){

                    Log.d(TAG,"down--->");
                }

                break;

            case KeyEvent.KEYCODE_DPAD_UP:   //向上键
                Log.d(TAG,"up--->");

                break;

            case     KeyEvent.KEYCODE_0:   //数字键0
                Log.d(TAG,"0--->");

                break;

            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键
//                jz_video.seek(-10000);
                Log.d(TAG,"left--->");

                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
                Log.d(TAG,"right--->");
//                jz_video.seek(10000);
                break;

            case KeyEvent.KEYCODE_INFO:    //info键
                Log.d(TAG,"info--->");

                break;

            case KeyEvent.KEYCODE_PAGE_DOWN:     //向上翻页键
            case KeyEvent.KEYCODE_MEDIA_NEXT:
                Log.d(TAG,"page down--->");

                break;


            case KeyEvent.KEYCODE_PAGE_UP:     //向下翻页键
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
                Log.d(TAG,"page up--->");

                break;

            case KeyEvent.KEYCODE_VOLUME_UP:   //调大声音键
                Log.d(TAG,"voice up--->");

                break;

            case KeyEvent.KEYCODE_VOLUME_DOWN: //降低声音键
                Log.d(TAG,"voice down--->");

                break;
            case KeyEvent.KEYCODE_VOLUME_MUTE: //禁用声音
                Log.d(TAG,"voice mute--->");
                break;

            default:
                break;
        }

        return super.onKeyDown(keyCode, event);

    }






}
