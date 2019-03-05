package com.example.infs3634_beers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import 	android.webkit.WebViewClient;
public class OpenWebsite extends AppCompatActivity {
    private WebViewClient client = new WebViewClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_website);


       // Intent intent = getIntent();
        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(client);
        webView.loadUrl("https://www.google.com");

    }
}
