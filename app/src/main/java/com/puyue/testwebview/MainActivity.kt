package com.puyue.testwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<View>(R.id.webview) as WebView

//加载网页链接
        webView.loadUrl("https://www.google.com/");//只能加载https URL http不行
//加载本地assets目录下的网页
//        webView.loadUrl("file:///web.html");
//加载手机本地的html页面
//        webView.loadUrl("content://com.android.htmlfileprovider/sdcard/keithxiaoy.html");
//加载 HTML 页面的一小段内容。参数1：需要截取展示的内容、参数2：展示内容的类型、参数3：字节码
//        webView.loadData(String data, String mimeType, String encoding)
    }
}