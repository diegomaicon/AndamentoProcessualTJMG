package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.diego.andamentoprocessualtjmg.MODELO.Processo;
import com.example.diego.andamentoprocessualtjmg.R;

public class ListaProcessosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_processos);
        Processo p = (Processo) getIntent().getSerializableExtra("processo");
        TextView et = (TextView) findViewById(R.id.tvOba);
        et.setText(p.getVara());
    }
}
