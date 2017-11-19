package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diego.andamentoprocessualtjmg.MODELO.Processo;
import com.example.diego.andamentoprocessualtjmg.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by diego on 24/10/17.
 */

public class BuscandoActivity extends AppCompatActivity{
    private static final String TAG = "Ex";
    private ProgressBar mProgress;
    private boolean alive = true;
    private TextView tv;


    public void uRLReader(String comrCodigo, String nomeParte) throws Exception {


        final String  link = "http://www4.tjmg.jus.br/juridico/sf/proc_resultado_nome.jsp?tipoPesquisa=2&txtProcesso=&comrCodigo="+comrCodigo+
                "&nomePessoa="+nomeParte+"&tipoPessoa=X&naturezaProcesso=0&situacaoParte=X&codigoOAB=&tipoOAB=N&ufOAB=MG&numero=1&select=1&tipoConsulta=1&natureza=0&ativoBaixado=X";

        Thread downloadThread = new Thread() {
            public void run() {
                Document html = null;
                try {
                    //Baixa HTML com caracter especial


                  html = Jsoup.parse(new URL(link).openStream(), "ISO-8859-9", link);



                    final Elements aviso = html.getElementsByClass("aviso");
                    if (aviso.size() > 0){

                        runOnUiThread(new Runnable() {
                            public void run() {

                                SpannableString spannableString = new SpannableString(aviso.select("strong").text()+"");
                                spannableString.setSpan(
                                        new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)),
                                        0,
                                        spannableString.length(),
                                        0);
                                Toast.makeText(BuscandoActivity.this,spannableString, Toast.LENGTH_LONG).show();
                                alive = false;
                                finish();
                            }
                        });

                    } else {
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
                            ArrayList<String> auxList1 = new ArrayList<String>();
                            ArrayList<String> auxList2 = new ArrayList<String>();
                            for (Element eleP : p) {
                                auxList1.add(eleP.text());
                            }
                            processo.setPartes(auxList1);


                            Elements mov = corpo.get(4).select("tr");

                            for (Element eleMov : mov) {
                                auxList2.add(eleMov.text());
                            }
                            processo.setMovimento(auxList2);

                            // passar objeto processo para outra Tela.
                            infoProcesso(processo);
                        }else {

                            infoProcesso(processo);
                        }
                    }

                } catch (IOException e) {

                    Log.d(TAG,"Erro Catch >>> "+e.getMessage());
                    chamaWebView(link);
                }

            }
        };
        downloadThread.start();

    }


    public void uRLReader(String comrCodigo, String listaProcessos, String numero) throws Exception {


        final String  link = "http://www4.tjmg.jus.br/juridico/sf/proc_resultado.jsp?" +
                "comrCodigo=" + comrCodigo + "&numero=" + 1 + "&listaProcessos=" + listaProcessos;//15003483;

        Thread downloadThread = new Thread() {
            public void run() {
                Document html = null;
                try {
                    //Baixa HTML com caracter especial


                    html = Jsoup.parse(new URL(link).openStream(), "ISO-8859-9", link);



                    final Elements aviso = html.getElementsByClass("aviso");
                    if (aviso.size() > 0){

                        runOnUiThread(new Runnable() {
                            public void run() {

                                SpannableString spannableString = new SpannableString(aviso.select("strong").text()+"");
                                spannableString.setSpan(
                                        new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)),
                                        0,
                                        spannableString.length(),
                                        0);
                                Toast.makeText(BuscandoActivity.this,spannableString, Toast.LENGTH_LONG).show();
                                alive = false;
                                finish();
                            }
                        });

                    } else {
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
                            ArrayList<String> auxList1 = new ArrayList<String>();
                            ArrayList<String> auxList2 = new ArrayList<String>();
                            for (Element eleP : p) {
                                auxList1.add(eleP.text());
                            }
                            processo.setPartes(auxList1);


                            Elements mov = corpo.get(4).select("tr");

                            for (Element eleMov : mov) {
                                auxList2.add(eleMov.text());
                            }
                            processo.setMovimento(auxList2);

                            // passar objeto processo para outra Tela.
                            infoProcesso(processo);
                        }else {

                            infoProcesso(processo);
                        }
                    }

                } catch (IOException e) {

                    Log.d(TAG,"Erro Catch >>> "+e.getMessage());
                    chamaWebView(link);
                }

            }
        };
        downloadThread.start();

    }



    public void urlReaderCaptcha(final String hlink) throws Exception {

        final String link = hlink;

        Thread downloadThread = new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void run() {
                Document html = null;
                try {
                    //Baixa HTML com caracter especial
                        html = Jsoup.parse(new URL(link).openStream(), StandardCharsets.ISO_8859_1.name() , link);


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
                        ArrayList<String> auxList1 = new ArrayList<String>();
                        ArrayList<String> auxList2 = new ArrayList<String>();
                        for (Element eleP : p) {
                            auxList1.add(eleP.text());
                        }
                        processo.setPartes(auxList1);


                        Elements mov = corpo.get(4).select("tr");

                        for (Element eleMov : mov) {
                            auxList2.add(eleMov.text());
                        }
                        processo.setMovimento(auxList2);

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
        try {
            Intent it = new Intent(this, ListaProcessosActivity.class);
            it.putExtra("processo", p);
            startActivity(it);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void chamaWebView(String html) {
        try {
            Intent it = new Intent(this, WebViewActivity.class);
            it.putExtra("link", html);
            startActivity(it);
            alive = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscando_splash);
        this.setTitle("");
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Barra de Progresso
        mProgress = (ProgressBar) findViewById(R.id.barraProgresso);

        String processo = (String) getIntent().getSerializableExtra("st");
        final StringTokenizer st = new StringTokenizer(processo,".-");

        //parte do código responsável por simular aproximadamente 2 segundos de processamento
        new Thread(new Runnable() {
            public void run() {

                try {
                    uRLReader(st.nextToken(), st.nextToken().concat(st.nextToken()), st.nextToken());
                } catch (Exception e) {

                }

                for (int i = 0; i <= 100; i++) {
                    if(!alive) {
                        Log.d(TAG, "Fim Progress");
                        break;
                    }

                    final int progress = i;

                    // Atualiza a barra de progresso
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Log.d(TAG, ">> Progress: " + progress);
                            mProgress.setProgress(progress);
                        }
                    });

                    //código responsável pelo delay de 200 milisegundos aproximadamente a cada rodada do for
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Log.i(TAG, "Fim.");
            }
        }).start();//fim da parte do código responsável por simular o processamento de 2 segundos aproximadamente

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        alive = false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}