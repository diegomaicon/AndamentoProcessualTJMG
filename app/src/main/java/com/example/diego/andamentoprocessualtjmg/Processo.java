package com.example.diego.andamentoprocessualtjmg;

import java.util.ArrayList;

/**
 * Created by diego on 07/09/17.
 */

public class Processo {
    private String numero;
    private String status;
    private String vara;
    private String classe;
    private String assunto;
    private String cs;

    private ArrayList<String> partes;
    private ArrayList<String> movimento;

    public Processo() {
    }

    public Processo(String numero, String status, String vara, String classe, String assunto, String cs,
                     ArrayList<String> partes, ArrayList<String> movimento) {
        this.numero = numero;
        this.status = status;
        this.vara = vara;
        this.classe = classe;
        this.assunto = assunto;
        this.cs = cs;

        this.partes = partes;
        this.movimento = movimento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }


    public ArrayList<String> getPartes() {
        return partes;
    }

    public void setPartes(ArrayList<String> partes) {
        this.partes = partes;
    }

    public ArrayList<String> getMovimento() {
        return movimento;
    }

    public void setMovimento(ArrayList<String> movimento) {
        this.movimento = movimento;
    }


}