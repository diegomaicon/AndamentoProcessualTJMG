package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.diego.andamentoprocessualtjmg.MODELO.Partes;
import com.example.diego.andamentoprocessualtjmg.R;

import java.util.StringTokenizer;

/**
 * Created by diego on 20/11/17.
 */

public class ListaPartesActivity  extends AppCompatActivity {
    private Partes p;


    private void buscandoProcesso(String st ) {
        Intent it = new Intent(this, BuscandoActivity.class);
        it.putExtra("st",  st);
        startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_partes);
        this.setTitle("Dados Resumidos");
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        p = (Partes) getIntent().getSerializableExtra("partes");


        TextView etSexo = (TextView) findViewById(R.id.tvSexo);
        TextView etNome = (TextView) findViewById(R.id.tvNomeParte);
        TextView etTipo = (TextView) findViewById(R.id.tvTipo);
        TextView etQtd = (TextView) findViewById(R.id.tvQtd);
        final ListView list = (ListView) findViewById(R.id.list);
        TextView etlinha1 = (TextView) findViewById(R.id.tvLinha1);
        TextView etlinha3 = (TextView) findViewById(R.id.tvlinha3);


        etlinha1.setText("_______________________________________________________");
        etlinha3.setText("_______________________________________________________");
        etNome.setText(p.getNome());
        etSexo.setText(p.getSexo());
        etQtd.setText(p.getQtd());
        etTipo.setText(p.getTipo());
        final ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,p.getProcessos());
        list.setAdapter( adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int posicao, long id) {
                String numero = p.getProcessos().get(posicao).toString();

                StringTokenizer st = new StringTokenizer(numero, ".-");

                String ini = st.nextToken();
                String aux = st.nextToken();
                String ano = st.nextToken();
                st.nextToken();
                st.nextToken();
                String comarca = st.nextToken();
                buscandoProcesso(comarca+"."+ano.substring(2,4)+"."+ini.substring(0,6)+"-"+aux);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,ParteProcessoActivity.class);
        startActivity(intent);

    }
}
