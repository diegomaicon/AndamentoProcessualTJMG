package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.diego.andamentoprocessualtjmg.DAO.dbCliente;
import com.example.diego.andamentoprocessualtjmg.MODELO.Adapter_Personalizado;
import com.example.diego.andamentoprocessualtjmg.MODELO.Cliente;
import com.example.diego.andamentoprocessualtjmg.R;

import java.util.List;

/**
 * Created by lukew on 02/11/2017.
 */

public class ListaClienteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cliente);

        dbCliente dbc = new dbCliente(getApplicationContext());
        List<Cliente> lista = dbc.listarClientes();

        ListView clientes = (ListView) findViewById(R.id.lvCliente);
        Adapter_Personalizado adapter = new Adapter_Personalizado(lista, this);
        clientes.setAdapter(adapter);
    }
}
