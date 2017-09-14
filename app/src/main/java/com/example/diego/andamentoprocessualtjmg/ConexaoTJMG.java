package com.example.diego.andamentoprocessualtjmg;



import java.net.*;
import java.io.*;
/**
 * Created by diego on 07/09/17.
 */


public class ConexaoTJMG {


    public static void URLReader(String comrCodigo, String listaProcessos, String numero)throws Exception{

        String link = "http://www4.tjmg.jus.br/juridico/sf/proc_resultado.jsp?"+
                       "comrCodigo="+comrCodigo+"&numero="+numero+"&listaProcessos="+listaProcessos;//15003483;

            URL oracle = new URL(link);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();

    }



}
