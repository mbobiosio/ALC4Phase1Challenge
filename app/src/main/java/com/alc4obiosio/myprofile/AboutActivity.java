package com.alc4obiosio.myprofile;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.alc4obiosio.myprofile.Constants.andela_url;

@SuppressLint("SetJavaScriptEnabled")
public class AboutActivity extends AppCompatActivity {

    WebView mWebView;
    ProgressDialog mProgress;
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mProgress = new ProgressDialog(this);

        initToolBar();
        initWebView();
    }

    private void initToolBar() {
        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
    }

    private void initWebView() {
        mWebView = findViewById(R.id.webView);
        mWebView.loadUrl(andela_url);
        mWebView.setWebViewClient(new CustomWebViewClient());
        mWebView.requestFocus();
        mWebView.getSettings().setJavaScriptEnabled(true);
    }

    private void showProgress() {
        mProgress.setMessage(getString(R.string.loading));
        mProgress.show();
    }


    private class CustomWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            showProgress();
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            mProgress.dismiss();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
