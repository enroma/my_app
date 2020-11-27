package ir.isiran.dastyarman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class WebExplorer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_explorer)

        val btnWebaddress = findViewById<Button>(R.id.btnWebAddress)
        val edtAddress = findViewById<EditText>(R.id.edtWebAddress)
        val webView=findViewById<WebView>(R.id.webview)

        webView.settings.javaScriptEnabled=true
        webView.settings.setSupportZoom(true)
        webView.webViewClient= WebViewClient()

        btnWebaddress.setOnClickListener(){
            val address = edtAddress.text.toString()
            webView.loadUrl(address)
        }
    }
}