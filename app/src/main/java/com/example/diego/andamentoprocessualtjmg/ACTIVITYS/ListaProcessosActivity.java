package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.diego.andamentoprocessualtjmg.DAO.dbProcesso;
import com.example.diego.andamentoprocessualtjmg.MODELO.Processo;
import com.example.diego.andamentoprocessualtjmg.R;

public class ListaProcessosActivity extends AppCompatActivity {

    private ImageButton btnCompartilhar;
    private Processo p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_processos);
        this.setTitle("Dados Resumidos");
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        dbProcesso dbp = new dbProcesso(getApplicationContext());

         p = (Processo) getIntent().getSerializableExtra("processo");


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
        TextView et18 = (TextView) findViewById(R.id.textView18);
        btnCompartilhar = (ImageButton) findViewById(R.id.btnCompartilhar);


        etVara.setText(p.getVara());
        etNumero.setText(p.getNumero());
        if (p.getStatus().equals("BAIXADO")) {
            etStatus.setText(p.getStatus());
            etStatus.setTextColor(Color.RED);
            etlinha1.setText("_______________________________________________________");
            etClasse.setText("");
            etCS.setText("");
            etAssunto.setText("");
            etPartes.setText("");
            etmovimentos.setText("");
            etlinha3.setText("");
            et18.setText("");
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

    public  void onClickCompartilhar(View v){
        // Compartilhar texto
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Compartilhar");
        if (p.getStatus().equals("ATIVO")) {
            String str = "";
            for (String s : p.getPartes()) {
                str += s + "\n";
            }
            String str2 = "";
            for (String s : p.getMovimento()) {
                str2 += s + "\n";
            }
            shareIntent.putExtra(Intent.EXTRA_TEXT, "PROCESSO " + p.getNumero() + "\n " +
                    "VARA " + p.getVara() + "\n" +
                    " " + p.getStatus() +"\n"+
                     str + "\n" +
                    "Movimentação :" + str2);
        }else{
            shareIntent.putExtra(Intent.EXTRA_TEXT, "PROCESSO " + p.getNumero() + "\n " +

                    "VARA " + p.getVara() + "\n "+ p.getStatus());
        }
        startActivity(shareIntent);

    }


}
