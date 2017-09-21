package com.example.diego.andamentoprocessualtjmg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

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
