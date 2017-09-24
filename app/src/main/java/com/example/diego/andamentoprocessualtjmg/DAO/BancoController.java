package com.example.diego.andamentoprocessualtjmg.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by diego on 24/09/17.
 */

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereCliente(String nome, String cpf, String telefone, String email) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.KEY_cliNome, nome);
        valores.put(CriaBanco.KEY_cliCpf, cpf);
        valores.put(CriaBanco.KEY_cliTelefone, telefone);
        valores.put(CriaBanco.KEY_cliEmail, email);
        resultado = db.insert(CriaBanco.TABELA_CLIENTE, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";


    }

    public Cursor carregaDadosCliente() {
        Cursor cursor;
        String[] campos = {banco.KEY_cliCodigo, banco.KEY_cliNome};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA_CLIENTE, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


}

