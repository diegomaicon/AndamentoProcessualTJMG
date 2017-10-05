package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.example.diego.andamentoprocessualtjmg.R;

/**
 * Created by diego on 05/10/17.
 */

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);


        webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("www.google.com.br");
        String html =
                "<html>";
        //permite o zoom
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        //seta a os dados da pÃ¡gina
        webView.loadData(html, "text/html", null);
    }


}
