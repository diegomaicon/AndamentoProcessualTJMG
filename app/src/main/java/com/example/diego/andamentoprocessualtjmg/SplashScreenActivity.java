package com.example.diego.andamentoprocessualtjmg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by diego on 17/09/17.
 */

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarPequisaNuProcesso();
            }
        }, 2000);
    }

    private void mostrarPequisaNuProcesso() {
        Intent intent = new Intent(SplashScreenActivity.this,
                NumeroProcessoActivity.class);
        startActivity(intent);
        finish();
    }

}

