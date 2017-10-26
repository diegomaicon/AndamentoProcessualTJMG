package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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

        final String link = (String) getIntent().getSerializableExtra("link");

        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(link);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                // Uma pagina comecou a ser carregada
               BuscandoActivity b = new BuscandoActivity();
                try {
                    b.urlReaderCaptcha(link);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // Uma pagina terminou de ser carregada

            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                // Carregando um recurso
            }
        });


    }


}
