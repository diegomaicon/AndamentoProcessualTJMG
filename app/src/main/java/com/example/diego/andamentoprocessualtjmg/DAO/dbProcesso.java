package com.example.diego.andamentoprocessualtjmg.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.diego.andamentoprocessualtjmg.MODELO.Cliente;
import com.example.diego.andamentoprocessualtjmg.MODELO.Processo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lukew on 02/11/2017.
 */

public class dbProcesso {
    public SQLiteDatabase db,dbr;

    public dbProcesso(Context context){
        CriaBanco cb = new CriaBanco(context);

        //acesso para escrita
        db = cb.getWritableDatabase();
        //acesso para leitura
        dbr = cb.getReadableDatabase();
    }

    public long insertProcesso(Processo processo){
        ContentValues values = new ContentValues();
        values.put("proNumero",processo.getNumero());
        values.put("proComarca",processo.getCs());
        values.put("proVara",processo.getVara());
        values.put("proStatus",processo.getStatus());
        return db.insert("processo",null,values);
    }

    public void deleteAllProcessos(){
        db.execSQL("DELETE FROM processo");
    }

    public void deleteProcessos(int proCodigo){
        String args[] = new String[]{proCodigo+""};
        db.delete("processo","proCodigo=?",args);
    }

    public List<Processo> listarProcessos() {
        // Cria lista
        List<Processo> listaProcesso = new LinkedList<Processo>();
        // Query do banco
        String query = "SELECT * FROM processo";
        // Cria o cursor e executa a query
        Cursor cursor = db.rawQuery(query, null);
        // Percorre os resultados
        // Se o cursor pode ir ao primeiro
        if (cursor.moveToFirst()) do {
            // Cria novo , cada vez que entrar aqui
            Processo processo = new Processo();
            // Define os campos da configuracao, pegando do cursor pelo id da coluna
            processo.setNumero(cursor.getString(0));
            processo.setCs(cursor.getString(1));
            processo.setVara(cursor.getString(2));
            processo.setStatus(cursor.getString(3));

            // Adiciona as informacoes
            listaProcesso.add(processo);
        }
        while (cursor.moveToNext()); // Enquanto o usuario pode mover para o proximo ele executa esse metodo
        // Retorna a lista
        return listaProcesso;
    }

    public List<Processo> buscarProcesso(String cod) {
        // Cria lista
        List<Processo> listaProcesso = new LinkedList<Processo>();
        // Query do banco
        //????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        Cursor cursor = db.query("processo",
                new String[]{"proNumero", "proStatus"},
                "proNumero=?", new String[]{String.valueOf(cod)},
                null, null, null);
        // Percorre os resultados
        if (cursor.moveToFirst()) {// Se o cursor pode ir ao primeiro
            do {
                // Cria novo , cada vez que entrar aqui
                Processo processo = new Processo();
                // Define os campos da configuracao, pegando do cursor pelo id da coluna
                processo.setNumero(cursor.getString(0));
                processo.setStatus(cursor.getString(1));

                // Adiciona as informacoes
                listaProcesso.add(processo);
            }
            while (cursor.moveToNext()); // Enquanto o usuario pode mover para o proximo ele executa esse metodo
        }
        // Retorna a lista
        return listaProcesso;
    }
}
