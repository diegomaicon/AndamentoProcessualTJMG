package com.example.diego.andamentoprocessualtjmg.MODELO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by diego on 19/11/17.
 */

public class Partes implements Serializable {
    private String nome;
    private String numero;
    private String sexo;
    private String tipo;
    private String Qtd;
    private ArrayList<String> processos;

    public Partes() {
    }

    public Partes(String nome, String numero, String sexo, String tipo, String qtd, ArrayList<String> processos) {
        this.nome = nome;
        this.numero = numero;
        this.sexo = sexo;
        this.tipo = tipo;
        Qtd = qtd;
        this.processos = processos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getQtd() {
        return Qtd;
    }

    public void setQtd(String qtd) {
        Qtd = qtd;
    }

    public ArrayList<String> getProcessos() {
        return processos;
    }

    public void setProcessos(ArrayList<String> processos) {
        this.processos = processos;
    }
}
