package com.weidingqiang.wanbase.ui.help.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootActivity;
import com.weidingqiang.wanbase.databinding.ActivityHelpBinding;
import com.weidingqiang.wanbase.model.bean.HelpVO;
import com.weidingqiang.wanbase.ui.help.contract.HelpContract;
import com.weidingqiang.wanbase.ui.help.presenter.HelpPresenter;
import com.weidingqiang.wanbase.widget.actionbar.XBaseTopBar;
import com.weidingqiang.wanbase.widget.actionbar.XBaseTopBarImp;

import butterknife.BindView;

/**
 * Created by skyworth
 */
public class HelpActivity extends RootActivity<HelpPresenter> implements HelpContract.View , XBaseTopBarImp {

    @BindView(R.id.webView)
    WebView webView;

//    @BindView(R.id.topbar_back_img)
//    ImageView topbar_back_img;

    private WebSettings mWebSettings;

    private String url;

    @BindView(R.id.main_topbar)
    XBaseTopBar main_topbar;
    /**
     * 打开新Activity
     *
     * @param context
     * @return
     */
    public static Intent newInstance(Context context,String url) {
        Intent intent = new Intent(context, HelpActivity.class);
        intent.putExtra("url",url);
        return intent;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_help;
    }

    @Override
    protected void initEventAndData() {

        //https://www.jianshu.com/p/2c4ac24761f5
        //DataBinding 说明
        ActivityHelpBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_help);
        HelpVO helpVO = new HelpVO("帮助","qasd");
        binding.setHelpVO(helpVO);


        main_topbar.setxBaseTopBarImp(this);

        url = getIntent().getStringExtra("url");

        mWebSettings = webView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);


        //设置不用系统浏览器打开,直接显示在当前Webview
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //设置WebChromeClient类
        webView.setWebChromeClient(new WebChromeClient() {


            //获取网站标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
//                System.out.println("标题在这里");
//                mtitle.setText(title);
            }


            //获取加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
//                if (newProgress < 100) {
//                    String progress = newProgress + "%";
//                    loading.setText(progress);
//                } else if (newProgress == 100) {
//                    String progress = newProgress + "%";
//                    loading.setText(progress);
//                }
            }
        });

        //设置WebViewClient类
        webView.setWebViewClient(new WebViewClient() {
            //设置加载前的函数
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                System.out.println("开始加载了");
//                beginLoading.setText("开始加载了");

            }

            //设置结束加载函数
            @Override
            public void onPageFinished(WebView view, String url) {
//                endLoading.setText("结束加载了");

            }
        });
    }

    @Override
    public void responeError(String errorMsg) {

    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            webView.clearHistory();

            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }

    @Override
    public void left() {
        finish();
    }

    @Override
    public void right() {

    }
}