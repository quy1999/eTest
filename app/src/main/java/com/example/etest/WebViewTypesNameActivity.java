package com.example.etest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.etest.activity.PresentActivity;
import com.example.etest.activity.TypeWorksActivity;

public class WebViewTypesNameActivity extends AppCompatActivity {

    private WebView webviewtypes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_types_name);
        webviewtypes=(WebView)findViewById(R.id.webviewtypes);
        webviewtypes.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME1");
        Toast.makeText(this, intent.getStringExtra("NAME1"), Toast.LENGTH_LONG).show();

        switch (name) {
            case "Danh từ":
                webviewtypes.loadUrl("file:///android_asset/detail/17.html");
                break;
            case "Đại từ":
                webviewtypes.loadUrl("file:///android_asset/detail/18.html");
                break;
            case "Động từ":
                webviewtypes.loadUrl("file:///android_asset/detail/19.html");
                break;
            case "Tính từ":
                webviewtypes.loadUrl("file:///android_asset/detail/20.html");
                break;
            case "Trạng từ":
                webviewtypes.loadUrl("file:///android_asset/detail/21.html");
                break;
            case "Giới từ":
                webviewtypes.loadUrl("file:///android_asset/detail/22.html");
                break;
            case "Liên từ":
                webviewtypes.loadUrl("file:///android_asset/detail/23.html");
                break;
            case "Thán từ":
                webviewtypes.loadUrl("file:///android_asset/detail/24.html");
                break;
            case "Mạo từ":
                webviewtypes.loadUrl("file:///android_asset/detail/25.html");
                break;
        }
    }
}
