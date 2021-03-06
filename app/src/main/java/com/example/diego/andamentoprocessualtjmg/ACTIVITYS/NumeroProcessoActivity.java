package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.diego.andamentoprocessualtjmg.LIB.Mask;
import com.example.diego.andamentoprocessualtjmg.R;

@SuppressWarnings("ResourceType")
public class NumeroProcessoActivity extends AppCompatActivity {

    private ImageButton btnPesquisa;
    private EditText edtProcesso;
    private TextWatcher proMask;


    private void buscandoProcesso(String st ) {
        Intent it = new Intent(this, BuscandoActivity.class);
        it.putExtra("st",  st);
        startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_processo);
        this.setTitle("Pesquisa por Número ");
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnPesquisa = (ImageButton) findViewById(R.id.botao_perquisa);

        edtProcesso = (EditText) findViewById(R.id.edtNome);
        proMask = Mask.insert("####.##.######-#", edtProcesso);
        edtProcesso.addTextChangedListener(proMask);

        btnPesquisa.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                String processo = edtProcesso.getText().toString();

                if(!processo.equals("")){
                    try {

                        Toast.makeText(NumeroProcessoActivity.this, "Buscanco Processo "+ processo, Toast.LENGTH_SHORT).show();
                        buscandoProcesso(processo);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                      Toast.makeText(NumeroProcessoActivity.this, "Informar  número ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,IndexActivity.class);
        startActivity(intent);

    }



}
