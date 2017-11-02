package com.example.diego.andamentoprocessualtjmg.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.diego.andamentoprocessualtjmg.MODELO.Cliente;

import java.util.LinkedList;
import java.util.List;


public class dbCliente {
    public SQLiteDatabase db,dbr;

    public dbCliente(Context context){
        CriaBanco cb = new CriaBanco(context);

        //acesso para escrita
        db = cb.getWritableDatabase();
        //acesso para leitura
        dbr = cb.getReadableDatabase();
    }


    public long insertCliente(Cliente cliente){
        ContentValues values = new ContentValues();
        values.put("cliNome",cliente.getNome());
        values.put("cliCPF",cliente.getCpf());
        values.put("cliTelefone",cliente.getTelefone());
        values.put("cliEmail",cliente.getEmail());
        return db.insert("cliente",null,values);
    }

    public void deleteAllClientes(){
        db.execSQL("DELETE FROM cliente");
    }

    public void deleteCliente(int cliCodigo){
        String args[] = new String[]{cliCodigo+""};
        db.delete("cliente","cliCodigo=?",args);
    }

    public List<Cliente> listarClientes() {
        // Cria lista
        List<Cliente> listaCliente = new LinkedList<Cliente>();
        // Query do banco
        String query = "SELECT * FROM cliente";
        // Cria o cursor e executa a query
        Cursor cursor = db.rawQuery(query, null);
        // Percorre os resultados
        // Se o cursor pode ir ao primeiro
        if (cursor.moveToFirst()) do {
            // Cria novo , cada vez que entrar aqui
            Cliente cliente = new Cliente();
            // Define os campos da configuracao, pegando do cursor pelo id da coluna
            cliente.setNome(cursor.getString(1));
            cliente.setCpf(cursor.getString(2));
            cliente.setTelefone(cursor.getString(3));
            cliente.setEmail(cursor.getString(4));

            // Adiciona as informacoes
            listaCliente.add(cliente);
        }
        while (cursor.moveToNext()); // Enquanto o usuario pode mover para o proximo ele executa esse metodo
        // Retorna a lista
        return listaCliente;
    }

    public List<Cliente> buscarCliente(String cod) {
        // Cria lista
        List<Cliente> listaCliente = new LinkedList<Cliente>();
        // Query do banco
        //????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        Cursor cursor = db.query("cliente",
                new String[]{"cliNome", "cliCPF","cliTelefone","cliEmail"},
                "cliCPF=?", new String[]{String.valueOf(cod)},
                null, null, null);
        // Percorre os resultados
        if (cursor.moveToFirst()) {// Se o cursor pode ir ao primeiro
            do {
                // Cria novo , cada vez que entrar aqui
                Cliente cliente = new Cliente();
                // Define os campos da configuracao, pegando do cursor pelo id da coluna
                cliente.setNome(cursor.getString(0));
                cliente.setCpf(cursor.getString(1));
                cliente.setTelefone(cursor.getString(2));
                cliente.setEmail(cursor.getString(3));

                // Adiciona as informacoes
                listaCliente.add(cliente);
            }
            while (cursor.moveToNext()); // Enquanto o usuario pode mover para o proximo ele executa esse metodo
        }
        // Retorna a lista
        return listaCliente;
    }

}
