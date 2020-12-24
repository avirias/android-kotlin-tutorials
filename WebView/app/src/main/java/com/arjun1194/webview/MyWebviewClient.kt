package com.arjun1194.webview

import android.webkit.*
import android.widget.Toast

class MyWebviewClient : WebViewClient() {

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        view?.let{ removeBanner(it) }
    }

    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest?
    ): WebResourceResponse? {

        println("Request headers are ---> ${request?.requestHeaders}")

        return super.shouldInterceptRequest(view, request)
    }



    private fun removeBanner(v:WebView){
        val js =""" 
            let removeBanner  = function(){
                document.getElementsByClassName('item')[0].remove()
            }
            
            let removeLogo  = function(){
                document.getElementsByClassName('logo-section')[0].remove()
            }
            
            removeBanner();
            removeLogo();
        """.trimIndent()
        v.evaluateJavascript(js) {
            println("Message from js ----> $it")
        }
    }
}