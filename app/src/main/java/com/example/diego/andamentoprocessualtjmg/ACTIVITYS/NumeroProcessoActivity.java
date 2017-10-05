package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;

import android.support.annotation.NonNull;

import android.support.design.widget.NavigationView;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;


import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.Menu;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.diego.andamentoprocessualtjmg.LIB.Mask;
import com.example.diego.andamentoprocessualtjmg.MODELO.Processo;
import com.example.diego.andamentoprocessualtjmg.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

@SuppressWarnings("ResourceType")
public class NumeroProcessoActivity extends AppCompatActivity {

        private ImageButton btnPesquisa;
        private EditText edtProcesso;
        private TextWatcher proMask;


    private void URLReader(String comrCodigo, String listaProcessos, String numero) throws Exception {

        final String link = "http://www4.tjmg.jus.br/juridico/sf/proc_resultado.jsp?" +
                "comrCodigo=" + comrCodigo + "&numero=" + numero + "&listaProcessos=" + listaProcessos;//15003483;

        Thread downloadThread = new Thread() {
            public void run() {
                Document html;
                try {
                    //Baixa HTML com caracter especial
                    html = Jsoup.parse(new URL(link).openStream(), "ISO-8859-9", link);

                    Elements form = html.select("table.tabela_formulario");
                    Elements corpo = html.select("table.corpo");

                    Processo processo = new Processo();
                    Elements b = form.select("b");
                    short aux = 1;
                    for (Element eleB : b) {
                        if (aux == 1) processo.setNumero(eleB.text());
                        if (aux == 2) processo.setVara(eleB.text());
                        if (aux == 3) processo.setStatus(eleB.text());
                        aux++;
                    }
                    aux = 1;

                    if (!processo.getStatus().equals("BAIXADO")) {

                        Elements eleClasse = corpo.get(1).select("tr");
                        for (Element eleC : eleClasse) {
                            if (aux == 1) processo.setClasse(eleC.text());
                            if (aux == 2) processo.setAssunto(eleC.text());
                            if (aux == 3) processo.setCs(eleC.text());
                            aux++;
                        }
                        aux = 1;


                        Elements autores = corpo.select("table#partes");
                        Elements p = autores.select("tr");
                        ArrayList<String> auxList = new ArrayList<String>();
                        for (Element eleP : p) {
                            auxList.add(eleP.text());
                        }
                        processo.setPartes(auxList);
                        auxList.clear();


                        Elements mov = corpo.get(4).select("tr");

                        for (Element eleMov : mov) {
                            auxList.add(eleMov.text());
                        }
                        processo.setMovimento(auxList);
                        auxList.clear();

                        // passar objeto processo para outra Tela.
                        infoProcesso(processo);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        downloadThread.start();

    }


    private void infoProcesso(Processo p) {
        Intent it = new Intent(this, ListaProcessosActivity.class);
        it.putExtra("processo", p);
        startActivity(it);
    }


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_numero_processo);
        this.setTitle("Pesquisa por Número ");
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        btnPesquisa = (ImageButton) findViewById(R.id.botao_perquisa);
            edtProcesso = (EditText) findViewById(R.id.edtProcesso);
            proMask = Mask.insert("####.##.######-#", edtProcesso);
            edtProcesso.addTextChangedListener(proMask);

            btnPesquisa.setOnClickListener(new Button.OnClickListener(){

                @Override
                public void onClick(View view) {
                    String processo = edtProcesso.getText().toString();
                    StringTokenizer st = new StringTokenizer(processo,".-");
                    if(st.hasMoreTokens()){
                        try {

                            Toast.makeText(NumeroProcessoActivity.this, "Buscanco Processo "+ processo, Toast.LENGTH_SHORT).show();
                            URLReader(st.nextToken(), st.nextToken().concat(st.nextToken()), st.nextToken());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

        }

}
