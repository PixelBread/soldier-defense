package com.mustafakamis.soldiergame

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private var soldierLoadCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ActionBar'ı kapat
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                if (url?.contains("soldier.html") == true) {
                    soldierLoadCount++
                    // Artık interstitial reklam yok
                }
            }
        }

        webView.settings.javaScriptEnabled = true

        // API 29 ve üzeri için forceDark ayarı
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            webView.settings.forceDark = WebSettings.FORCE_DARK_OFF
        }

        webView.loadUrl("file:///android_asset/soldier.html")
    }
}
