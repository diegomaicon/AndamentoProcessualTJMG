package com.example.diego.andamentoprocessualtjmg;



import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by diego on 07/09/17.
 */


public class ConexaoTJMG {


    public static void URLReader(String comrCodigo, String listaProcessos, String numero)throws Exception{

                final String link = "http://www4.tjmg.jus.br/juridico/sf/proc_resultado.jsp?"+
                       "comrCodigo="+comrCodigo+"&numero="+numero+"&listaProcessos="+listaProcessos;//15003483;

                    Thread downloadThread = new Thread() {
                        public void run() {
                            try {
                               //Baixa HTML com caracter especial
                                Document html =  Jsoup.parse(new URL(link).openStream(), "ISO-8859-1", link);

                                Elements form = html.select("table.tabela_formulario");
                                Elements corpo = html.select("table.corpo");

                                Processo processo = new Processo();
                                Elements b = form.select("b");
                                short aux=1;
                                for (Element eleB:b) {
                                    if (aux == 1) processo.setNumero(eleB.text());
                                    if (aux == 2) processo.setVara(eleB.text());
                                    if (aux == 3) processo.setStatus(eleB.text());
                                    aux++;
                                }
                                aux=1;

                                if (!processo.getStatus().equals("BAIXADO")) {

                                    Elements eleClasse = corpo.get(1).select("tr");
                                    for (Element eleC:eleClasse) {
                                        if (aux == 1) processo.setClasse(eleC.text());
                                        if (aux == 2) processo.setAssunto(eleC.text());
                                        if (aux == 3) processo.setCs(eleC.text());
                                        aux++;
                                    }
                                    aux=1;


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
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    downloadThread.start();

       // Elements status = html.select("div.time-status span.status");
       // Elements times1 = html.select("div.team1");
       // Elements times2 = html.select("div.team2");
    }



}
