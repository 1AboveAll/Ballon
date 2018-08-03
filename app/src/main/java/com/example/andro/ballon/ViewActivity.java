package com.example.andro.ballon;

import android.content.Intent;
import android.media.tv.TvContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {

    Intent intent;
    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        intent = getIntent();

        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setHomeButtonEnabled(true);
        }

        webView = findViewById(R.id.activity_view_web_view);
        progressBar = findViewById(R.id.activity_view_progress_bar);


        webView.loadUrl(intent.getStringExtra(MainActivity.KEY));

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                Toast.makeText(ViewActivity.this,"PageLoaded",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });
    }
}
