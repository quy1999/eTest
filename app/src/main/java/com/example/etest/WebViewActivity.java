package com.example.etest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.etest.activity.GrammarActivity;
import com.example.etest.activity.PresentActivity;
import com.example.etest.activity.TypeWorksActivity;
import com.example.etest.main.MainActivity;
import com.example.etest.model.Present;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        Toast.makeText(this, intent.getStringExtra("NAME"), Toast.LENGTH_LONG).show();

        switch (name) {
            case "Các thì trong tiếng anh":
                Intent intent1 = new Intent(WebViewActivity.this, PresentActivity.class);
                startActivity(intent1);
                break;
            case "Các dạng thức của động từ":
                webView.loadUrl("file:///android_asset/detail/14.html");
                break;
            case "Động từ khuyết thiếu":
                webView.loadUrl("file:///android_asset/detail/15.html");
                break;
            case "Các loại từ":
                Intent intent2 = new Intent(WebViewActivity.this, TypeWorksActivity.class);
                startActivity(intent2);
               break;
            case "So sánh câu trong Tiếng Anh":
                webView.loadUrl("file:///android_asset/detail/26.html");
                break;
            case "Câu bị động":
                webView.loadUrl("file:///android_asset/detail/27.html");
                break;
            case "Câu gián tiếp":
                webView.loadUrl("file:///android_asset/detail/28.html");
                break;
            case "Sự hoà hợp giữa chủ ngữ và động từ":
                webView.loadUrl("file:///android_asset/detail/32.html");
                break;
            case "Cấu tạo từ":
                webView.loadUrl("file:///android_asset/detail/33.html");
                break;
            case "Đảo ngữ":
                webView.loadUrl("file:///android_asset/detail/34.html");
                break;
            case "Sự kết hợp từ":
                webView.loadUrl("file:///android_asset/detail/35.html");
                break;
            case "Mệnh đề":
                webView.loadUrl("file:///android_asset/detail/36.html");
                break;
            case "Ngữ âm":
                webView.loadUrl("file:///android_asset/detail/37.html");
                break;
            case "Câu điều kiện":
                webView.loadUrl("file:///android_asset/detail/30.html");
                break;
            case "Câu điều ước":
                webView.loadUrl("file:///android_asset/detail/31.html");
                break;
            case "Cụm động từ":
                webView.loadUrl("file:///android_asset/detail/39.html");
                break;
            case "Một số động từ đặc biệt(need,dare,to be,get)":
                webView.loadUrl("file:///android_asset/detail/40.html");
                break;
            case "Câu hỏi":
                webView.loadUrl("file:///android_asset/detail/41.html");
                break;
            case "Lối nói phụ hoạ trong tiếng anh":
                webView.loadUrl("file:///android_asset/detail/42.html");
                break;
            case "Câu phủ định":
                webView.loadUrl("file:///android_asset/detail/43.html");
                break;
            case "Câu giả định":
                webView.loadUrl("file:///android_asset/detail/44.html");
                break;
            case "Cách sử dụng một số cấu trúc":
                webView.loadUrl("file:///android_asset/detail/45.html");
                break;
            case "Các cụm từ diễn tả số lượng":
                webView.loadUrl("file:///android_asset/detail/46.html");
                break;
            case "Much,many,a lot of và lots of-trong một số trường hợp khác":
                webView.loadUrl("file:///android_asset/detail/47.html");
                break;
            case "Sự phù hợp về thời gian giữa hai vế của một câu":
                webView.loadUrl("file:///android_asset/detail/48.html");
                break;
            case "100 cụm từ thường gặp":
                webView.loadUrl("file:///android_asset/detail/1000.html");
                break;
            case "Một số cấu trúc thông dụng trong tiếng anh(phần 1)":
                webView.loadUrl("file:///android_asset/detail/1001.html");
                break;
            case "Một số cấu trúc thông dụng trong tiếng anh(phần 2)":
                webView.loadUrl("file:///android_asset/detail/1002.html");
                break;
            case "Một số cấu trúc thông dụng trong tiếng anh(phần 3)":
                webView.loadUrl("file:///android_asset/detail/1003.html");
                break;
            case "Đọc hiểu":
                webView.loadUrl("file:///android_asset/detail/1999.html");
                break;
            case "Bảng động từ bất quy tắc":
                webView.loadUrl("file:///android_asset/detail/2000.html");
                break;

        }

    }
}
