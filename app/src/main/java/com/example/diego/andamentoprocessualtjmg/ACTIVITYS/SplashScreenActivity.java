package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.diego.andamentoprocessualtjmg.R;

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
                IndexActivity.class);
        startActivity(intent);
        finish();
    }

}

