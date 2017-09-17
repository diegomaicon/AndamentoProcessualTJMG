package com.example.diego.andamentoprocessualtjmg;



import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.*;
import java.io.*;
/**
 * Created by diego on 07/09/17.
 */


public class ConexaoTJMG {


    public static void URLReader(String comrCodigo, String listaProcessos, String numero)throws Exception{

                final String link = "http://www4.tjmg.jus.br/juridico/sf/proc_resultado.jsp?"+
                       "comrCodigo="+comrCodigo+"&numero="+numero+"&listaProcessos="+listaProcessos;//15003483;

                    Thread downloadThread = new Thread() {
                        public void run() {
                            Document html;
                            try {
                                 html = Jsoup.connect(link).get();
                                Elements form = html.select("table.tabela_formulario");
                                Elements corpo = html.select("table.corpo");
                                System.out.print(form.toString());

                                //Toast.makeText(R.layout.activity_principal,"Retorno: ", Toast.LENGTH_SHORT).show();
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
