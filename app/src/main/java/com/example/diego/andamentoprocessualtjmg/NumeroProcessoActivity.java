package com.example.diego.andamentoprocessualtjmg;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.StringTokenizer;

public class NumeroProcessoActivity extends AppCompatActivity {

        private ImageButton btnPesquisa;
        private EditText edtProcesso;
        private TextWatcher proMask;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_principal);
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


            btnPesquisa = (ImageButton) findViewById(R.id.botao_perquisa);
            edtProcesso = (EditText) findViewById(R.id.edtProcesso);
            proMask = Mask.insert("####.##.######-#", edtProcesso);
            edtProcesso.addTextChangedListener(proMask);

            btnPesquisa.setOnClickListener(new Button.OnClickListener(){

                @Override
                public void onClick(View view) {
                    String processo = edtProcesso.getText().toString();
                    StringTokenizer st = new StringTokenizer(processo,".-");
                    if(st.hasMoreTokens()){
                        try {

                            Toast.makeText(NumeroProcessoActivity.this, "Buscanco Processo "+ processo, Toast.LENGTH_SHORT).show();
                            ConexaoTJMG.URLReader(st.nextToken(),st.nextToken().concat(st.nextToken()),st.nextToken());


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

        }




    }
