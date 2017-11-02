package com.example.diego.andamentoprocessualtjmg.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by diego on 24/09/17.
 */

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "bancoAP.db";
    private static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        criaTabelaCliente(db);
        criaTabelaProcesso(db);
    }

    private void criaTabelaProcesso(SQLiteDatabase db){
        String sqlCreateTabelaProcesso = "CREATE TABLE IF NOT EXISTS processo ("
                + "proCodigo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "proNumero VARCHAR(100),"
                + "proComarca TEXT,"
                + "proVara TEXT,"
                + "proStatus TEXT"
                + ");";
        db.execSQL(sqlCreateTabelaProcesso);
    }

    private void criaTabelaCliente (SQLiteDatabase db){
        String sqlCreateTabelaCliente = "CREATE TABLE IF NOT EXISTS cliente ("
                + "cliCodigo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "cliNome VARCHAR(100),"
                + "cliCPF VARCHAR(12),"
                + "cliTelefone VARCHAR(15),"
                + "cliEmail VARCHAR(100)"
                + ");";
        db.execSQL(sqlCreateTabelaCliente);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS cliente");
        db.execSQL("DROP TABLE IF EXISTS processo");
        onCreate(db);
    }
}
