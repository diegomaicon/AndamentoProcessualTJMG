package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diego.andamentoprocessualtjmg.DAO.dbProcesso;
import com.example.diego.andamentoprocessualtjmg.LIB.PDF;
import com.example.diego.andamentoprocessualtjmg.MODELO.Processo;
import com.example.diego.andamentoprocessualtjmg.R;

public class ListaProcessosActivity extends AppCompatActivity {

    private ImageButton btnCompartilhar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_processos);
        this.setTitle("Dados Resumidos");
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        dbProcesso dbp = new dbProcesso(getApplicationContext());

        final Processo p = (Processo) getIntent().getSerializableExtra("processo");


        if(dbp.buscarProcesso(p.getNumero()).size()<1) {
            dbp.insertProcesso(p);
        }

        TextView etVara = (TextView) findViewById(R.id.tvVara);
        TextView etNumero = (TextView) findViewById(R.id.tvNumero);
        TextView etStatus = (TextView) findViewById(R.id.tvStatus);
        TextView etlinha1 = (TextView) findViewById(R.id.tvLinha1);
        TextView etClasse = (TextView) findViewById(R.id.tvClasse);
        TextView etAssunto = (TextView) findViewById(R.id.tvAssunto);
        TextView etCS = (TextView) findViewById(R.id.tvCS);
        TextView etlinha3 = (TextView) findViewById(R.id.tvlinha3);
        TextView etPartes = (TextView) findViewById(R.id.tvPartes);
        TextView etmovimentos = (TextView) findViewById(R.id.tvMovimento);
        btnCompartilhar = (ImageButton) findViewById(R.id.btnCompartilhar);
        btnCompartilhar.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                    try {
                        //gera o pdf
                        new PDF(p,p.getNumero());
                        Toast.makeText(getBaseContext(),"PDF criado!",Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        });

        etVara.setText(p.getVara());
        etNumero.setText(p.getNumero());
        if (p.getStatus().equals("BAIXADO")) {
            etStatus.setText(p.getStatus());
            etStatus.setTextColor(Color.RED);
            etlinha1.setText("_______________________________________________________");
        } else {
            etStatus.setText(p.getStatus());
            etStatus.setTextColor(Color.GREEN);
            etlinha1.setText("_______________________________________________________");
            etClasse.setText(p.getClasse());
            etCS.setText(p.getCs());
            etAssunto.setText(p.getAssunto());
            etlinha3.setText("_______________________________________________________");
            String str = "";
            for (String s : p.getPartes()) {
                str += s + "\n";
            }
            etPartes.setText(str);

            String str2 = "";
            for (String s : p.getMovimento()) {
                str2 += s + "\n";
            }
            etmovimentos.setText(str2);

        }


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,NumeroProcessoActivity.class);
        startActivity(intent);

    }


}
