package com.example.sabong

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the WebView
        val webView = findViewById<WebView>(R.id.webView)

        // Enable WebView debugging
        WebView.setWebContentsDebuggingEnabled(true)

        // Configure WebView settings
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true // Enable DOM storage (if needed)
        webView.settings.userAgentString = "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.101 Mobile Safari/537.36"

        // Set a WebViewClient for handling page loading and errors
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.d("MyWebView", "Page has finished loading: $url")
            }

            override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
                super.onReceivedError(view, errorCode, description, failingUrl)
                Log.e("MyWebView", "Error: $description")
            }
        }

        // Load the URL
        webView.loadUrl("https://h5.salanfun.top/")
    }
}
