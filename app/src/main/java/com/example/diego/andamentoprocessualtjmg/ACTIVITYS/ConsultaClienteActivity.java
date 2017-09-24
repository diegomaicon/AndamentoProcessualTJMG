package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.diego.andamentoprocessualtjmg.DAO.BancoController;
import com.example.diego.andamentoprocessualtjmg.DAO.CriaBanco;
import com.example.diego.andamentoprocessualtjmg.R;

public class ConsultaClienteActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_cliente);

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDadosCliente();


        String[] nomeCampos = new String[]{CriaBanco.KEY_cliCodigo, CriaBanco.KEY_cliNome};
        int[] idViews = new int[]{R.id.codigo, R.id.nome};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_cliente, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adaptador);
    }

}
