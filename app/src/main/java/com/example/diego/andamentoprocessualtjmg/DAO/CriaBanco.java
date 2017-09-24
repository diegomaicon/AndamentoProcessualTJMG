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


    static final String TABELA_CLIENTE = "cliente";
    public static final String KEY_cliCodigo = "cli_Codigo";
    public static final String KEY_cliNome = "cli_Nome";
    static final String KEY_cliCpf = "cli_Cpf";
    static final String KEY_cliTelefone = "cli_Telefone";
    static final String KEY_cliEmail = "cli_Email";


    private static final String TABELA_PROCESSO = "processo";
    private static final String KEY_proCodigo = "pro_Codigo";
    private static final String KEY_proNumero = "pro_Numero";
    private static final String KEY_proComarca = "pro_Comarca";
    private static final String KEY_proVara = "pro_Vara";
    private static final String KEY_proStatus = "pro_Status";
    private static final String KEY_pro_cliCodigo = "pro_cliCodigo";


    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateCliente = "CREATE TABLE" + TABELA_CLIENTE + "("
                + KEY_cliCodigo + "integer primary key autoincrement,"
                + KEY_cliNome + "text,"
                + KEY_cliCpf + "text,"
                + KEY_cliTelefone + "text,"
                + KEY_cliEmail + "text);";

        String sqlCreateProcesso = "CREATE TABLE" + TABELA_PROCESSO + "("
                + KEY_proCodigo + "integer primary key autoincrement,"
                + KEY_proNumero + "text,"
                + KEY_proComarca + "text,"
                + KEY_proVara + "text,"
                + KEY_proStatus + "text,"
                + "CONSTRAINT " + KEY_pro_cliCodigo + " FOREIGN KEY(cli_Codigo) REFERENCES cliente)"
                + ");";


        db.execSQL(sqlCreateProcesso);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_PROCESSO);
        onCreate(db);
    }
}
