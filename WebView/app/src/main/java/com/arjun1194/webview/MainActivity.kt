package com.arjun1194.webview

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var webView: WebView
    lateinit var webviewClient: WebViewClient
    lateinit var webChromeClient: WebChromeClient

    val url = "https://oe.amizone.net"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webview)
        initWebview()

    }

    fun initWebview(){
        webviewClient = MyWebviewClient()
        webChromeClient = WebChromeClient()
        //webviewClient.in
        webView.webViewClient = webviewClient
        webView.webChromeClient = webChromeClient
        webView.clearCache(true)
        webView.clearHistory()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)


    }
}