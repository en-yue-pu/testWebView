package com.puyue.testwebview

import android.net.http.SslError
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById<View>(R.id.webview) as WebView//从UI拿实例过来,对他进行操作
//        webView.settings.javaScriptEnabled = true
//        webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
//        webView.settings.domStorageEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                Log.d("MainActivity", url.toString())
                view?.loadUrl(url.toString())
                return true
            }

            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler,
                error: SslError?
            ) {
                Log.d("MainActivity", error.toString())
                handler.proceed() // Ignore SSL certificate errors  //本地服务器无法签名 需要在这里忽略问题
            }
        }
        webView.loadUrl("https://192.168.10.3:8080/web2.html")//macbook的ip

        //加载网页链接
//        webView.loadUrl("https://192.168.10.3:8080/web2.html")//只能加载https URL http不行
//加载本地assets目录下的网页
//        webView.loadUrl("file:///web99.html");
//加载手机本地的html页面
//        webView.loadUrl("content://com.android.htmlfileprovider/sdcard/keithxiaoy.html");
//加载 HTML 页面的一小段内容。参数1：需要截取展示的内容、参数2：展示内容的类型、参数3：字节码
//        webView.loadData(String data, String mimeType, String encoding
    }
}