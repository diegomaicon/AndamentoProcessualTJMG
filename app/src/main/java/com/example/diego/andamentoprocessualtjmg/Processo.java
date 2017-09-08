package com.example.diego.andamentoprocessualtjmg;

import java.util.ArrayList;

/**
 * Created by diego on 07/09/17.
 */

public class Processo {
    private int numero;
    private boolean status;
    private String vara;
    private String classe;
    private String assunto;
    private String cs;
    private String autor;
    private ArrayList<String> reu;
    private ArrayList<String> movimento;

    public Processo() {
    }

    public Processo(int numero, boolean status, String vara, String classe, String assunto, String cs,
                    String autor, ArrayList<String> reu, ArrayList<String> movimento) {
        this.numero = numero;
        this.status = status;
        this.vara = vara;
        this.classe = classe;
        this.assunto = assunto;
        this.cs = cs;
        this.autor = autor;
        this.reu = reu;
        this.movimento = movimento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ArrayList<String> getReu() {
        return reu;
    }

    public void setReu(ArrayList<String> reu) {
        this.reu = reu;
    }

    public ArrayList<String> getMovimento() {
        return movimento;
    }

    public void setMovimento(ArrayList<String> movimento) {
        this.movimento = movimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Processo processo = (Processo) o;

        if (numero != processo.numero) return false;
        if (status != processo.status) return false;
        if (vara != null ? !vara.equals(processo.vara) : processo.vara != null) return false;
        if (classe != null ? !classe.equals(processo.classe) : processo.classe != null)
            return false;
        if (assunto != null ? !assunto.equals(processo.assunto) : processo.assunto != null)
            return false;
        if (cs != null ? !cs.equals(processo.cs) : processo.cs != null) return false;
        if (autor != null ? !autor.equals(processo.autor) : processo.autor != null) return false;
        if (reu != null ? !reu.equals(processo.reu) : processo.reu != null) return false;
        return movimento != null ? movimento.equals(processo.movimento) : processo.movimento == null;

    }

    @Override
    public int hashCode() {
        int result = numero;
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (vara != null ? vara.hashCode() : 0);
        result = 31 * result + (classe != null ? classe.hashCode() : 0);
        result = 31 * result + (assunto != null ? assunto.hashCode() : 0);
        result = 31 * result + (cs != null ? cs.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (reu != null ? reu.hashCode() : 0);
        result = 31 * result + (movimento != null ? movimento.hashCode() : 0);
        return result;
    }
}
