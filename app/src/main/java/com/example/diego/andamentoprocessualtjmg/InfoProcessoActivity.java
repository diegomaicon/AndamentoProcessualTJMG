package com.example.diego.andamentoprocessualtjmg;

import android.content.pm.ActivityInfo;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.nodes.Document;

import java.util.StringTokenizer;

public class InfoProcessoActivity extends AppCompatActivity {
    private TextView numPro;
    private Document doc;

    public InfoProcessoActivity(Document d){
        this.doc = d;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processos);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        numPro = (TextView) findViewById(R.id.txtNum);
    }
}
