package com.example.etest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class WebViewPrisentActivity extends AppCompatActivity {

    private WebView webViewpresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_prisent);

        webViewpresent = (WebView) findViewById(R.id.webviewpresent);
        webViewpresent.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Toast.makeText(this, intent.getStringExtra("name"), Toast.LENGTH_LONG).show();


        switch (name) {

            case "Thì hiện tại đơn":
                webViewpresent.loadUrl("file:///android_asset/detail/2.html");
                break;
            case "Thì hiện tại tiếp diễn":
                webViewpresent.loadUrl("file:///android_asset/detail/3.html");
                break;
            case "Thì hiện tại hoàn thành":
                webViewpresent.loadUrl("file:///android_asset/detail/4.html");
                break;
            case "Thì hiện tại hoàn thành tiếp diễn":
                webViewpresent.loadUrl("file:///android_asset/detail/5.html");
                break;
            case "Thì quá khứ tiếp diễn":
                webViewpresent.loadUrl("file:///android_asset/detail/6.html");
                break;
            case "Thì quá khứ hoàn thành":
                webViewpresent.loadUrl("file:///android_asset/detail/7.html");
                break;
            case "Thì quá khứ hoàn thành tiếp diễn":
                webViewpresent.loadUrl("file:///android_asset/detail/8.html");
                break;
            case "Thì tương lai đơn":
                webViewpresent.loadUrl("file:///android_asset/detail/9.html");
                break;
            case "Thì tương lai tiếp diễn":
                webViewpresent.loadUrl("file:///android_asset/detail/10.html");
                break;
            case "Thì tương lai hoàn thành":
                webViewpresent.loadUrl("file:///android_asset/detail/11.html");
                break;
            case "Thì tương lai hoàn thành tiếp diễn":
                webViewpresent.loadUrl("file:///android_asset/detail/12.html");
                break;

        }
    }
}


